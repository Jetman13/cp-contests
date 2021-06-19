package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ADenseArray {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            int ans = 0;
            for (int i = 1; i < n; i++) {
                int min = Math.min(a[i],a[i-1]);
                int max = Math.max(a[i],a[i-1]);
                while (min*2 < max) {
                    ans++;
                    min*=2;
                }
                //ans += Math.max(a[i],a[i-1]) - Math.min(a[i],a[i-1]);
            }
            out.println(ans);
        }
    }
}
