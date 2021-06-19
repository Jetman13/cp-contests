package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class MagicalCandyStore {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            boolean allone = n%2 == 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                if (a[i] != 1L) {
                    allone = false;
                }
            }
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                long r = in.nextLong();
                if (allone) {
                    out.println(r);
                }
            }

        }
    }
}
