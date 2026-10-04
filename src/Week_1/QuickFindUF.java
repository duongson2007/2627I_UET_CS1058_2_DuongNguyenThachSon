package Week_1;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class QuickFindUF {

    private int[] parent, sz;

    public void make_set(int n) {

        parent = new int[n + 1];
        sz = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int[] get_parent() {
        return this.parent;
    }

    public int find(int p) {
        if (p == parent[p]) return p;
        int v = find(parent[p]);
        parent[p] = v;
        return p;

        // return p == parent[p] ? p : parent[p] = find(parent[p]);
    }

    public void union(int p, int q) {
        int a = find(p);
        int b = find(q);
        if (a != b) {
            if (sz[a] < sz[b]) {
                // Dat bien a la goc cua cay co kich co lon hon
                int tmp  = a;
                a = b;
                b = tmp;
            }
            parent[b] = a;
            sz[a] += sz[b];
        }
    }

    public static void main(String[] args) {
        In in = new In("input.txt");

        if (!in.hasNextChar()) return;
        int n = in.readInt();

        QuickFindUF qf = new QuickFindUF();

        qf.make_set(n);

        if (!in.hasNextChar()) return;
        int q = in.readInt();

        for (int i = 0; i < q; i++) {
            if (in.hasNextChar()) {
                int x = in.readInt();
                int y = in.readInt();

                qf.union(x, y);
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(qf.get_parent(), 1, qf.get_parent().length)));
    }
}
