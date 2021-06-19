package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class Task2 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            double x1 = in.nextLong();
            double y1 = in.nextLong();
            double r1 = in.nextLong();
            double x2 = in.nextLong();
            double y2 = in.nextLong();
            double r2 = in.nextLong();
            double row = Math.abs(x1-x2);
            double col = Math.abs(y1-y2);
            double dis = Math.sqrt(row*row + col*col);
            if (dis > r1 + r2) {
                out.println("NO");
            } else {
                double minr = Math.min(r1,r2);
                double maxr = Math.max(r1,r2);
                if (dis + minr < maxr) {
                    out.println("NO");
                } else {
                    out.println("YES");
                }
            }
        }
    }
}
