package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CSimilarArrays {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        long mid = a[n/2];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(mid-a[i]);
        }
        out.println(ans);
    }
}
