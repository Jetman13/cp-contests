package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AFairPlayoff {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int[] a = new int[4];
            in.readArr(a);
            if (Math.max(a[0],a[1]) > Math.min(a[2],a[3]) && Math.min(a[0],a[1]) < Math.max(a[2],a[3])) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }
}
