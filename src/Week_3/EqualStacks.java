package Week_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class EqualStacks {

    public static int equalStacks(Stack<Integer> h1, Stack<Integer> h2, Stack<Integer> h3, int sum1, int sum2, int sum3) {
        int i1 = 0, i2 = 0, i3 = 0;

        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1.pop();
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2.pop();
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= h3.pop();
            }
        }

        return sum1;
    }

    public static void main(String[] args) {
        In in = new In("input.txt");

        if (!in.hasNextChar()) return;

        int n1 = in.readInt();
        int n2 = in.readInt();
        int n3 = in.readInt();

        int sum1 = 0, sum2 = 0, sum3 = 0;

        Stack<Integer> h1 = new Stack<>();
        Stack<Integer> h2 = new Stack<>();
        Stack<Integer> h3 = new Stack<>();

        int[] t1 = new int[n1];
        int[] t2 = new int[n2];
        int[] t3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            t1[i] =  in.readInt();
            sum1 += t1[i];
        }
        for (int i = 0; i < n2; i++) {
            t2[i] =  in.readInt();
            sum2 += t2[i];
        }
        for (int i = 0; i < n3; i++) {
            t3[i] =  in.readInt();
            sum3 += t3[i];
        }

        for (int i = n1 - 1; i >= 0; i--) {
            h1.push(t1[i]);
        }
        for (int i = n2 - 1; i >= 0; i--) {
            h2.push(t2[i]);
        }
        for (int i = n3 - 1; i >= 0; i--) {
            h3.push(t3[i]);
        }

        StdOut.println(equalStacks(h1, h2, h3, sum1, sum2, sum3));
    }
}

// 5 3 4
//3 2 1 1 1
//4 3 2
//1 1 4 1

// 5