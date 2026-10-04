package edu.princeton.cs.algs4;

public class w3_tailop_25020348 {

    private static int precedence(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return -1;
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder(); 
        Stack<Character> stack = new Stack<>();      

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    postfix.append(infix.charAt(i));
                    i++;
                }
                postfix.append(' ');
                i--;
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty()) stack.pop();
            }
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString().trim(); 
    }

    public static void main(String[] args) {
        //In in = new In(args[0]);
        In in = new In("input.txt");
        String[] expressions = in.readAllStrings();
        
        for (String infix : expressions) {
            StdOut.println("Trung tố: " + infix);
            StdOut.println("Hậu tố  : " + infixToPostfix(infix));
            StdOut.println();
        }
    }
}