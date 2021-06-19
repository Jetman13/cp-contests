package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class WorthyMatrix {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve(in,out);
        }
    }

    private void solve(FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();
        int[][] a = new int[n+2][m+2];
        long[][] sum = new long[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i+1][j+1] = in.nextInt();
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + a[i+1][j+1];
            }
        }

        long ans = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                ans += cal(sum,i,j,k);
            }
        }
        out.println(ans);


    }

    private long cal(long[][] sum, int i, int j, long k) {
        int n = sum.length;
        int m = sum[0].length;
        int l = 0;
        int r = Math.min(n-i,m-j)-1;
        int p = r+1;
        while (l <= r) {
            int mid = (l + r)/2;
            int ni = i + mid;
            int nj = j + mid;
            int num = (mid+1)*(mid+1);
            long all = sum[ni][nj] + sum[i-1][j-1] - sum[ni][j-1] - sum[i-1][nj];
            if (num*k <= all) {
                r = mid - 1;
                p = mid;
            } else {
                l = mid + 1;
            }
        }
        return Math.min(n-i,m-j) - p;
    }
}
