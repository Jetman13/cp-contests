package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CMadeUp {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[in.nextInt()]++;
        }

        int[] b = new int[n];
        in.readArr(b);
        int[] c = new int[n];
        in.readArr(c);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int tmp = b[c[i]-1];
            ans += a[tmp];
        }
        out.println(ans);

    }
}
