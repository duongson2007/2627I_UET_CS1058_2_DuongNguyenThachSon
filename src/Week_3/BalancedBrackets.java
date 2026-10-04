package Week_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) return "NO";
                char top = stack.pop();
                if ((top == '{' && c != '}') || (top == '[' && c != ']') || (top == '(' && c != ')')) return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String args[]) {
        In in = new In("input.txt");

        if (!in.hasNextChar()) return;
        int n = in.readInt();

        for (int i = 0; i < n; i++) {
            String s = in.readString();
            StdOut.println(isBalanced(s));
        }
    }
}

// 3
//{[()]}
//{[(])}
//{{[[(())]]}}

// YES
//NO
//YES