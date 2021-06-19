package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BMinimalCost {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long u = in.nextLong();
            long v = in.nextLong();

            int[] a = new int[n];
            in.readArr(a);
            
            int max = 0;
            for (int i = 1; i < a.length; i++) {
                max = Math.max(max,Math.abs(a[i]-a[i-1]));
            }

            if (max >= 2) {
                out.println(0);
                continue ;
            }
            if (max == 0) {
                out.println(Math.min(v*2,u+v));
            } else {
                out.println(Math.min(u,v));
            }
            
        }
    }
}
