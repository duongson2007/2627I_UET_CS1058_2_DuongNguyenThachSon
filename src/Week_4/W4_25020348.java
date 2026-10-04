package Week_4;

import edu.princeton.cs.algs4.In;

public class W4_25020348 {

    public static void insertionSort(int[] a, int n) {
        for (int i = 2; i <= n; i++) {
            int j = i - 1;
            boolean ok = false;
            int temp = a[i];
            while (j >= 1 && !ok) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    ok = true;
                }
            }
            a[j + 1] = temp;
        }
    }


    public static void main(String[] args) {
        In in = new In("input.txt");

        if (!in.hasNextChar()) return;
        int n = in.readInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.readInt();
        }

        insertionSort(a, n);

        int hIndex = n;
        while (hIndex > 0) {
            if(a[n - hIndex + 1] >= hIndex) {
                break;
            }
            else {
                hIndex -= 1;
            }
        }

        System.out.println(hIndex);
    }
}
