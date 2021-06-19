package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BAlcoholic {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long x = in.nextLong()*100L;
        int[][] a = new int[n][2];
        in.readArr(a);

        long pre = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (pre > x) {
                ans = i;
                break;
            }
            pre += a[i][0] * (a[i][1]);
        }
        if (ans == -1 && pre > x) {
            ans = n;
        }
        out.println(ans );
    }
}
