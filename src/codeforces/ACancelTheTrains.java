package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class ACancelTheTrains {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[101];
            int[] b = new int[101];
            for (int i = 0; i < n; i++) {
                a[in.nextInt()] = 1;
            }
            for (int i = 0; i < m; i++) {
                b[in.nextInt()] = 1;
            }
            int ans = 0;
            for (int i = 0; i < 101; i++) {
                if (a[i] + b[i] == 2) {
                    ans++;
                }
            }
            out.println(ans);
        }
    }
}
