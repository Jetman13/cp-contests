package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BKEYENCEBuilding {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        boolean[] f = new boolean[1002];
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                int tmp = 4*i*j + 3*i + 3*j;
                if (tmp <= 1000) {
                    f[tmp] = true;
                }
            }
        }

        int n = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!f[in.nextInt()]) {
                ans++;
            }
        }
        out.println(ans);
    }
}
