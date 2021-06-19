package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ARegularBracketSequence {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            String str = in.nextLine();
            int len = str.length();
            if (len % 2 == 1) {
                out.println("NO");
                continue;
            }
            int a = 0;
            int b = 0;
            int c = 0;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == '(') {
                    a++;
                } else if (str.charAt(i) == ')') {
                    b++;
                } else {
                    c++;
                }
            }
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            if (min + c < max) {
                out.println("NO");
                continue;
            }

        }
    }
}
