package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BNewYearAndNorthPole {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int up = 0;
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            String op = in.next();
            if (op.equals("South")) {
                up-=k;
                if (up < -20000) {
                    break;
                }
            } else if (op.equals("North")) {
                up+=k;
                if (up > 0) {
                    break;
                }
            } else if (op.equals("East")) {
                if (up == 0 || up == -20000) {
                    up = 1;
                    break;
                }

            } else {
                if (up == 0 || up == -20000) {
                    up = 1;
                    break;
                }

            }
        }

        out.println(up == 0 ? "YES":"NO");

    }
}
