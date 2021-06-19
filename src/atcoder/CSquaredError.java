package atcoder;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.Arrays;

public class CSquaredError {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        in.readArr(a);
        RuffleSort.ruffleSort(a);

        long[] dp = new long[n+1];
        long sum = 0;
        dp[1] = 0;
        for (int i = 1; i < n; i++) {
            long k = a[i] - a[i-1];
            dp[i+1] = dp[i] + 2*k*(sum) + k*k*(i);
            sum += k*i;
        }
        out.println(Arrays.stream(dp).sum());

    }
}
