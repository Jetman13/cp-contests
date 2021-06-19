package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class CCompassWalking {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        double r = in.nextDouble();
        double x = in.nextDouble();
        double y = in.nextDouble();

        double dis = Math.sqrt(x*x + y*y);

        if (Math.abs(dis-r) < 0.0001) {
            out.println(1);
            return ;
        } else if (dis < r) {
            out.println(2);
            return ;
        }


        int ans = (int)(dis/r);
        for (int i = 0; i < 5; i++) {
            if ((ans+i)*r >= dis) {
                ans = ans + i;
                break;
            }
        }
        out.println(ans);

    }
}
