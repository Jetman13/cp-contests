package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Issuelifehappy {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        long l = Arrays.stream(a).min().getAsLong();
        long r = Arrays.stream(a).sum();
        long ans = r;
        while (l <= r) {
            long mid = (l+r)/2L;

            if (check(a,m,mid)) {
                r = mid - 1;
                ans = Math.min(mid,ans);
            } else {
                l = mid + 1;
            }
        }
        out.println(ans);

    }

    private boolean check(long[] a, int m, long mid) {
        int k = 0;
        long pre = 0;
        for (int i = 0; i < a.length; i++) {
            if (pre + a[i] > mid) {
                k++;
                pre = a[i];
            } else {
                pre += a[i];
            }
        }
        k++;
        return k <= m;
    }
}
