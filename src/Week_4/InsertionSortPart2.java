package Week_4;

import edu.princeton.cs.algs4.In;

public class InsertionSortPart2 {

    public static void insertIntoSorted(int[] arr, int idx) {
        int a = arr[idx];
        int i = idx - 1;

        while(i >= 0 && arr[i] > a) {
            arr[i + 1] = arr[i];
            i--;
        }

        arr[i + 1] = a;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            insertIntoSorted(arr, i);
            printArray(arr);
        }
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

        insertionSort(a);
    }
}

// 6
//1 4 3 5 6 2

// 1 4 3 5 6 2
//1 3 4 5 6 2
//1 3 4 5 6 2
//1 3 4 5 6 2
//1 2 3 4 5 6