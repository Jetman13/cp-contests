package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BWeakPassword {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();
        boolean f = true;
        for (int i = 1; i < 4; i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                f = false;
            }
        }
        if (f) {
            out.println("Weak");
            return ;
        }

        s += s.charAt(0);
        f = true;
        for (int i = 0; i < 3; i++) {
            if (((s.charAt(i)-'0'+1)%10) != s.charAt(i+1) - '0') {
                f = false;
            }
        }
        out.println(!f ? "Strong":"Weak");
    }
}
