package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class FZebraness {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        char[][] chs = new char[n+2][n+2];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < n; j++) {
                chs[i+1][j+1] = s.charAt(j);
            }
        }

        long[][][] dp = new long[n+1][n+1][2];
        // B->1 W->0
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (chs[i][j] == 'B') {
                }
            }
        }



    }
}
