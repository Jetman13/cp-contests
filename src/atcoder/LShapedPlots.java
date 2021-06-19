package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class LShapedPlots {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] map = new int[r+2][c+2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = in.nextInt();
            }
        }

        int[][] dpl = caldpl(map,r,c);
        int[][] dpr = caldpr(map,r,c);
        int[][] dpu = caldpu(map,r,c);
        int[][] dpd = caldpd(map,r,c);

        long ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) continue;
                ans += cal(dpu[i+1][j+1],dpr[i+1][j+1]);
                ans += cal(dpr[i+1][j+1],dpd[i+1][j+1]);
                ans += cal(dpd[i+1][j+1],dpl[i+1][j+1]);
                ans += cal(dpl[i+1][j+1],dpu[i+1][j+1]);
            }
        }
        out.println("Case #" + testNumber + ": "+ans);

    }

    private long cal(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int num = 0;
        //one
        if (a > 3) {
            if (a / 2 <= b) {
                num += a / 2 - 1;
            } else {
                num += b - 1;
            }
        }

        //two
        if (b > 3) {
            if (b / 2 <= a) {
                num += b / 2 - 1;
            } else {
                num += a - 1;
            }
        }
        return num;
    }

    private int[][] caldpd(int[][] map, int r, int c) {
        int[][] dp = new int[r+2][c+2];
        for (int i = 0; i < c; i++) {
            for (int j = r-1; j >= 0; j--) {
                if (map[j][i] == 1) {
                    dp[j+1][i+1] = dp[j+2][i+1]+1;
                } else {
                    dp[j+1][i+1] = 0;
                }
            }
        }
        return dp;
    }

    private int[][] caldpu(int[][] map, int r, int c) {
        int[][] dp = new int[r+2][c+2];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (map[j][i] == 1) {
                    dp[j+1][i+1] = dp[j][i+1]+1;
                } else {
                    dp[j+1][i+1] = 0;
                }
            }
        }
        return dp;
    }

    private int[][] caldpl(int[][] map, int r, int c) {
        int[][] dp = new int[r+2][c+2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 1) {
                    dp[i+1][j+1] = dp[i+1][j]+1;
                } else {
                    dp[i+1][j+1] = 0;
                }
            }
        }
        return dp;
    }
    private int[][] caldpr(int[][] map, int r, int c) {
        int[][] dp = new int[r+2][c+2];
        for (int i = 0; i < r; i++) {
            for (int j = c-1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    dp[i+1][j+1] = dp[i+1][j+2]+1;
                } else {
                    dp[i+1][j+1] = 0;
                }
            }
        }
        return dp;
    }
}
