package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BSignOfFriendship {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        double d = in.nextDouble();
        double h = in.nextDouble();
        double[][] dh = new double[n][2];
        double ans = 0;
        for (int i = 0; i < n; i++) {
            dh[i][0] = in.nextDouble();
            dh[i][1] = in.nextDouble();
            if (Math.abs(d-dh[i][0]) < 0.0001) {
                ans = Math.max(ans,h);
            } else {
                ans = Math.max(ans, h - (h - dh[i][1]) * d / (d - dh[i][0]));
            }
        }
        out.println(ans);

    }
}
