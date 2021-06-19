package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BJobAssignment {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[][] a = new int[n][2];
        in.readArr(a);

        int ans = 10000002;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    ans = Math.min(ans,a[i][0] + a[j][1]);
                } else {
                    ans = Math.min(ans,Math.max(a[i][0],a[j][1]));
                }
            }
        }
        out.println(ans);
    }
}
