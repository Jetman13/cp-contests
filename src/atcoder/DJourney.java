package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DJourney {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        double[] dp = new double[n+1];
        dp[1] = 0.0;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-1] * (i/(i+1.0));
            double sum = 1.0/i;
            for (int j = 1; j <= 1000; j++) {
                dp[i] += j*sum;
                sum*=(i-1.0)/i;
            }
        }
        out.println(dp[n]);
    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        return null;
    }

    public static void main(String[] args) {
        new DJourney().countPairs(4,new int[][]{{1,2},{2,4},{1,3},{2,3},{2,1}},new int[]{2,3});
    }

}
