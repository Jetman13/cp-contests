package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CFloorAndMod {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            long x = in.nextLong();
            long y = in.nextLong();
            long mod = (long)(Math.sqrt(x)+0.001);
            long ans = 0;
            for (int i = 1; i <= mod ; i++) {
                long min = i+2;
                long max = x/i;
                if (max-1 > y) {
                    max = y+1;
                }
                if (max < min) continue;
                ans += max-min+1;
            }
            out.println(ans);
        }
    }
}
