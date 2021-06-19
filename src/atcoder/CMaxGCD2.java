package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CMaxGCD2 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();


        int ans = 1;
        for (int i = b; i >= 1; i--) {
            int tmp = (a%i == 0) ? a : (a/i + 1)*i;

            if (tmp >= a && tmp <= b && tmp + i >= a && tmp + i <= b) {
                ans = i;
                break;
            }
        }
        out.println(ans);

    }
}
