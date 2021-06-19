package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ComputesMatrix {
    long MOD = (long)1e9 + 7;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[2];
            int[] b = new int[2];
            in.readArr(a);
            in.readArr(b);

            if (a[0] > b[0] || a[1] > b[1]) {
                out.println(0);
                continue;
            }

            long ans = 0;
            for (long i = a[0]; i <= b[0]; i++) {
                long s = i*a[1];
                long e = s + (b[1]-a[1]) * (long)i;
                ans = (ans + (b[1]-a[1]+1) * (s + e)/2)%MOD;
            }
            out.println(ans);

        }
    }
}
