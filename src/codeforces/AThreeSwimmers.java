package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AThreeSwimmers {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long p = in.nextLong();
            long[] a = new long[3];
            in.readArr(a);

            long ans = Arrays.stream(a).max().getAsLong();

            for (int i = 0; i < 3; i++) {
                ans = Math.min(ans,a[i] - (p%a[i] == 0 ? a[i] : p%a[i]));
            }

            out.println(ans);

        }
    }
}
