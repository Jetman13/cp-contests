package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class DLinearProbing {
    int[] fa;
    int fa(int root) {
        return fa[root] == root ? root : (fa[root] = fa(fa[root]));
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long[] a = new long[2000001];
        Arrays.fill(a,-1);

        fa = new int[2000001];
        Arrays.setAll(fa,i->i);

        int q = in.nextInt();
        long h = 0;
        int n = (1<<20);
        for (int i = 0; i < q; i++) {
            int t = in.nextInt();

            if (t == 1) {
                h = in.nextLong();
                int index = (int)(h%n);
                int f = fa(index);
                a[f] = h;
                int next = (f+1)%n;
                fa[f] = next;
            } else {
                int index = (int)(in.nextLong()%n);
                out.println(a[index]);
            }

        }
    }
}
