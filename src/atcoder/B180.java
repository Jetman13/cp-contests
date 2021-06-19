package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class B180 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {
                ans.append("9");
            } else if (sb.charAt(i) == '9') {
                ans.append("6");
            } else {
                ans.append(sb.charAt(i));
            }
        }
        out.println(ans.toString());

    }
}
