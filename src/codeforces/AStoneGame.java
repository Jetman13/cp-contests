package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AStoneGame {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            int min = Arrays.stream(a).min().getAsInt();
            int max = Arrays.stream(a).max().getAsInt();

            int ans = 0;
            int lmin = 0;
            int rmin = 0;
            int lmax = 0;
            int rmax = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == min) {
                    lmin = i+1;
                    rmin = n-i;
                }
                if (a[i] == max) {
                    lmax = i+1;
                    rmax = n-i;
                }
            }

            ans = Math.min(Math.max(lmin,lmax),Math.max(rmin,rmax));
            ans = Math.min(ans,lmin+rmax);
            ans = Math.min(ans,rmin+lmax);
            out.println(ans);

        }
    }
}
