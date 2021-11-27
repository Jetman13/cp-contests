package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class EPlacingRectangles {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long x = in.nextLong();
        long y = in.nextLong();
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();

        if (check(x, y, a, b, c)) {
            out.println("Yes");
            return;
        }
        if (check(x, y, b, a, c)) {
            out.println("Yes");
            return;
        }
        if (check(x, y, c, b, a)) {
            out.println("Yes");
            return;
        }
        if (check(y, x, a, b, c)) {
            out.println("Yes");
            return;
        }
        if (check(y, x, b, a, c)) {
            out.println("Yes");
            return;
        }
        if (check(y, x, c, b, a)) {
            out.println("Yes");
            return;
        }
        out.println("No");
    }

    private boolean check(long x, long y, long a, long b, long c) {
        long tmp = a/x;
        if (tmp*x < a) {
            tmp++;
        }
        if (tmp >= y) return false;

        if (check(x,y-tmp,b,c)) return true;
        if (check(x,y-tmp,c,b)) return true;
        if (check(y-tmp,x,b,c)) return true;
        if (check(y-tmp,x,c,b)) return true;

        return false;
    }

    private boolean check(long x, long y, long b, long c) {
        long tmp = b/y;
        if (tmp*y < b) tmp++;

        if (tmp >= x) return false;

        return (x-tmp)*y >= c;

    }

}

