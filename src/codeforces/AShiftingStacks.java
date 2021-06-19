package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AShiftingStacks {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            in.readArr(a);
            boolean ans = true;
            long pre = a[0];
            for (int i = 1; i < n; i++) {
                if (a[i] + pre < i) {
                    ans = false;
                    break;
                }
                pre = a[i] + pre - i;
            }
            out.println(ans?"YES":"NO");
        }
    }
}
