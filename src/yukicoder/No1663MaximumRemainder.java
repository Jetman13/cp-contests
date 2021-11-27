package yukicoder;

import tool.FastReader;
import java.io.PrintWriter;

public class No1663MaximumRemainder {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        int m = in.nextInt();
        int ans = 0;
        for (int i = a; i <= b ; i++) {
            for (int j = c; j <= d; j++) {
                ans = Math.max(ans,(i+j)%m);
            }
        }
        out.println(ans);
    }
}
