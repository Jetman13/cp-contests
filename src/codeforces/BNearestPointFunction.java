package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BNearestPointFunction {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            boolean f = false;
            for (int i = 1; i < n; i++) {
                if ((a[i]-a[i-1])%2==0) {
                    f = true;
                    break;
                }
            }
            out.println(f ? "YES":"NO");
        }
    }
}
