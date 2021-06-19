package atcoder;

import tool.Com;
import tool.FastReader;
import java.io.PrintWriter;

public class DAabAbaBaa {
    long[][] c;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextLong();
        long b = in.nextLong();
        long k = in.nextLong();

        c = new long[100][100];

        com();


        StringBuilder sb = new StringBuilder();
        int anum = (int)a;
        int bnum = (int)b;
        long l = 1;
        long r = c[anum+bnum][anum];
        while (l <= k && k <= r && l < r) {
            long mid = l + c[anum+bnum-1][bnum];
            if (k < mid) {
                r = mid-1;
                sb.append("a");
                anum--;
            } else {
                l = mid;
                sb.append("b");
                bnum--;
            }
        }
        if (anum > 0) {
            for (int i = 0; i < anum; i++) {
                sb.append("a");
            }
        } else if (bnum > 0) {
            for (int i = 0; i < bnum; i++) {
                sb.append("b");
            }
        }
        out.println(sb.toString());

    }

    private void com() {
        for (int i = 1; i <= 60 ; i++) {
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || i == j) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = c[i-1][j] + c[i-1][j-1];
                }
            }
        }

    }
}
