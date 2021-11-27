package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class Zech {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long m = in.nextLong();
        int[] a = new int[n];
        in.readArr(a);

        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (sum + a[i]*(i+1L) <= m) {
                sum += a[i]*(i+1L);
                ans += a[i];
            } else {
                long tmp = (m - sum)/(i+1);
                sum += a[i]*tmp;
                ans += tmp;
                sum = m;
                break;
            }
        }
        if (sum == m) {
            out.println(ans);
        } else {
            out.println(-1);
        }
    }
}
