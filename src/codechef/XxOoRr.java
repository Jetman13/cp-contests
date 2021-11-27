package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class XxOoRr {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            int[] num = new int[34];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 32; j++) {
                    num[j] += (a[i]&(1<<j)) > 0 ? 1 : 0;
                }
            }

            int ans = 0;
            for (int i = 0; i < 32; i++) {
                ans += num[i]/k + ((num[i]%k!=0) ? 1 : 0);
            }
            out.println(ans);
        }
    }
}
