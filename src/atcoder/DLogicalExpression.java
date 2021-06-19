package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DLogicalExpression {
    int[] a;
    int n;
    long[][] dp;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        n = in.nextInt();
        a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (in.next().equals("AND")) a[i] = 1;
        }


        dp = new long[n+2][2];

        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            if (a[i] == 1) {
                dp[i][0] = dp[i-1][1] + dp[i-1][0]*2;
                dp[i][1] = dp[i-1][1];
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1]*2 + dp[i-1][0];
            }
        }
        out.println(dp[n][1]);

//        dp = new long[n+2][n+2][2];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                for (int k = 0; k < 2; k++) {
//                    dp[i][j][k] = -1;
//                }
//            }
//        }
//        out.println(work(0,n-1,1));
    }

//    private long work(int l, int r, int b) {
//        if (l > r) {
//            return 1;
//        }
//        if (l == r) {
//            if (a[l] == 1 && b == 1) return dp[l][r][b] = 1;
//            else if (a[l] == 1 && b == 0) return dp[l][r][b] = 3;
//            else if (a[l] == 0 && b == 1) return dp[l][r][b] = 3;
//            else return dp[l][r][b] = 1;
//        }
//        if (dp[l][r][b] != -1 ) return dp[l][r][b];
//        int mid = (l+r)/2;
//        if (a[mid] == 1) {
//            //AND
//            if (b == 1) {
//                return dp[l][r][b] = work(l, mid - 1, b) * work(mid + 1,r, b);
//            } else {
//                long num = 0;
//                num += work(l,mid-1,0) * work(mid+1,r,0);
//                num += work(l,mid-1,0) * work(mid+1,r,1);
//                num += work(l,mid-1,1) * work(mid+1,r,0);
//                return dp[l][r][b] = num;
//            }
//        } else {
//            if (b == 1) {
//                long num = 0;
//                num += work(l,mid-1,1) * work(mid+1,r,0);
//                num += work(l,mid-1,1) * work(mid+1,r,1);
//                num += work(l,mid-1,0) * work(mid+1,r,1);
//                return dp[l][r][b] = num;
//            } else {
//                return dp[l][r][b] = work(l, mid - 1, 0) * work(mid + 1,r, 0);
//            }
//        }
//    }
}
