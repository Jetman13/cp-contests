package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BBilliards {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        double sx = in.nextLong();
        double sy = in.nextLong();
        double gx = in.nextLong();
        double gy = in.nextLong();

        if (sx < gx) {
            double tx = sx;
            double ty = sy;
            sx = gx;
            sy = gy;
            gx = tx;
            gy = ty;
        }
        if (sx - gx < 0.1) {
            out.println(sx);
            return ;
        }

        double x = sy/gy*gx + sx;
        x /= (sy/gy+1.0);
        out.println(x);

    }
}
