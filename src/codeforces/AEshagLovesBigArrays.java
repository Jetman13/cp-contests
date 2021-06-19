package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AEshagLovesBigArrays {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            Arrays.sort(a);
            int ans = n;
            for (int i = 1; i < n; i++) {
                if (a[i] != a[i-1]) {
                    ans = i;
                    break;
                }
            }
            out.println(n - ans);
        }
    }
}
