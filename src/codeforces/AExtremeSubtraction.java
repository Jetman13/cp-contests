package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AExtremeSubtraction {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            boolean f = true;
            int rnum = 0;
            int lmin = a[0];
            for (int i = 1; i < n; i++) {
                a[i] -= rnum;
                if (a[i] < 0) {
                    f = false;
                    break;
                }
                if (lmin < a[i]) {
                    rnum += (a[i] - lmin);
                } else {
                    lmin = a[i];
                }
            }
            out.println(f?"YES":"NO");
        }
    }
}
