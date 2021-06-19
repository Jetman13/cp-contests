package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BSuffixOperations {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            long sum = 0;
            for (int i = n-2; i >= 0; i--) {
                sum+=Math.abs(a[i]-a[i+1]);
            }

            long ans = sum;
            for (int i = 0; i < n; i++) {
                int pre = a[i];
                int next = a[i];
                if (i-1 >= 0) pre = a[i-1];
                if (i+1 < n) next = a[i+1];
                if (i == 0) {
                    ans = Math.min(ans,sum-Math.abs(a[i]-next));
                } else if (i == n-1) {
                    ans = Math.min(ans,sum-Math.abs(a[i]-pre));
                } else {
                    ans = Math.min(ans, sum + Math.abs(next - pre) - Math.abs(a[i] - pre) - Math.abs(a[i] - next));
                }
            }
            out.println(ans);

        }
    }
}
