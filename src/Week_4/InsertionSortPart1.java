package Week_4;

import edu.princeton.cs.algs4.In;

public class InsertionSortPart1 {

    public static void insertIntoSorted(int[] arr) {
        int n = arr.length;
        int a = arr[n - 1];
        int i = n - 2;

        while(i >= 0 && a < arr[i]) {
            arr[i + 1] = arr[i];
            printArray(arr);
            i--;
        }

        arr[i + 1] = a;
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i != arr.length - 1 ? " " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        In in = new In("input.txt");

        if (!in.hasNextChar()) return;
        int n = in.readInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.readInt();
        }

        insertIntoSorted(a);
    }
}

// 5
//2 4 6 8 3

// 2 4 6 8 8
//2 4 6 6 8
//2 4 4 6 8
//2 3 4 6 8