package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CCalendarValidator {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long[][] a = new long[n][m];
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextLong();
                long mod = (a[i][j]-1)%7;
                if (j > 0 && mod != ((a[i][j-1]-1)%7) + 1) {
                    ans = false;
                }
                if (i > 0 && mod != ((a[i-1][j]-1)%7)) {
                    ans = false;
                }
            }
        }
        out.println(ans ? "Yes":"No");

    }
}
