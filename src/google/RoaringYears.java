package google;

import tool.FastReader;
import java.io.PrintWriter;

public class RoaringYears {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long y = in.nextLong();

        while (true) {
            y++;
            if (check(y)) {
                break;
            }
        }
        out.println("Case #" + testNumber + ": " + y);
    }

    private boolean check(long y) {
        String ystr = y + "";
        int len = ystr.length();
        for (int i = 1; i <= len/2; i++) {
            long next = Long.valueOf(ystr.substring(0,i));
            int p = i;
            boolean f = true;
            while (p < len) {
                next++;
                String nstr = next + "";
                if (!ystr.startsWith(nstr, p)) {
                    f = false;
                    break;
                }
                p += nstr.length();
            }
            if (f) {
                return true;
            }
        }
        return false;
    }
}
