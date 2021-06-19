package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BOrthogonality {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        Arrays.setAll(a,i->in.nextLong());
        Arrays.setAll(b,i->in.nextLong());

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i]*b[i];
        }
        out.print(ans==0?"Yes":"No");
    }
}
