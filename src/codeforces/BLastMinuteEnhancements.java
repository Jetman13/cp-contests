package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BLastMinuteEnhancements {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int  t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            Arrays.sort(a);
            int[] f = new int[n*2+3];
            for (int i = 0; i < n; i++) {
                f[a[i]]++;
            }
            int ans = 0;
            for (int i = 0; i < n*2+2; i++) {
                if (f[i] > 0) ans++;
                if (f[i] > 1) f[i+1]++;
            }
            out.println(ans);
        }
    }
}
