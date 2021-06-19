package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class EQueenOnGrid {

    long MOD = (long)1e9 + 7;

    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int h = in.nextInt();
        int w = in.nextInt();
        char[][] grid = new char[h+2][w+2];
        Arrays.fill(grid[0],'#');
        for (int i = 1; i <= h; i++) {
            String str = in.nextLine();
            Arrays.fill(grid[i],'#');
            for (int j = 1; j <= w; j++) {
                grid[i][j] = str.charAt(j-1);
            }
        }
        Arrays.fill(grid[h+1],'#');

        long[][] dp = new long[h+2][w+2];
        long[][][] sum = new long[h+2][w+2][3];
        dp[1][1] = 1;
        for (int i = 1; i <= h ; i++) {
            for (int j = 1; j <= w; j++) {
                if (grid[i][j] == '#') continue;

                dp[i][j] = (dp[i][j] + sum[i-1][j][0] + sum[i][j-1][1] + sum[i-1][j-1][2])%MOD;

                sum[i][j][0] = (sum[i-1][j][0] + dp[i][j])%MOD;
                sum[i][j][1] = (sum[i][j-1][1] + dp[i][j])%MOD;
                sum[i][j][2] = (sum[i-1][j-1][2] + dp[i][j])%MOD;

                //up
//                int i = i-1;
//                long sum = 0;
//                while (grid[i][j] == '.') {
//                    sum = (sum+dp[i][j])%MOD;
//                    i--;
//                }
//                //left
//                i = j-1;
//                while (grid[i][i] == '.') {
//                    sum = (sum+dp[i][i])%MOD;
//                    i--;
//                }
//                i = 1;
//                while (grid[i-i][j-i] == '.') {
//                    sum = (sum+dp[i-i][j-i])%MOD;
//                    i++;
//                }
//                dp[i][j] = (dp[i][j] + sum)%MOD;
            }
        }
        out.println(dp[h][w]);

    }
}
