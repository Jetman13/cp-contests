package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ADoNotBeDistracted {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.nextLine();
            boolean[] f = new boolean[30];
            f[s.charAt(0)-'A'] = true;
            boolean flag = true;
            for (int i = 1; i < n; i++) {
                int c = s.charAt(i) - 'A';
                if (c == s.charAt(i-1)-'A') continue;

                if (f[c]) {
                    flag = false;
                    break;
                }
                f[c] = true;
            }
            out.println(flag ? "YES":"NO");
        }
    }
}
