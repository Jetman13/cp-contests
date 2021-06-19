package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BPalindromeWithLeadingZeros {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();

        String str = n + "";

        boolean f = false;

        if (check(str)) {
            out.println("Yes");
            return;
        }
        for (int i = 0; i < 100; i++) {
            str = "0" + str;
            if (check(str)) {
                f = true;
                break;
            }
        }

        out.println(f ? "Yes":"No");


    }

    boolean check(String s) {
        int len = s.length();
        if (len <= 1) return true;

        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len-i-1)) return false;
        }
        return true;
    }
}
