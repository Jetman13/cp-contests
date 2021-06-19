package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BLastYearsSubstring {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.nextLine();
            if ("2020".equals(s) || "2020".equals(s.substring(0,4)) || "2020".equals(s.substring(n-4))) {
                out.println("YES");
                continue;
            }
            boolean f = false;
            for (int i = 1; i <= 3; i++) {
                if (check(s,i)) {
                    f = true;
                    break;
                }
            }
            out.println(f?"YES":"NO");
        }
    }

    private boolean check(String s, int i) {
        String tmp = s.substring(0,i) + s.substring(s.length()-(4-i));
        return "2020".equals(tmp);
    }
}
