package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BNonSubstringSubsequence {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int q = in.nextInt();
            String s = in.nextLine();


            for (int i = 0; i < q; i++) {
                int l = in.nextInt()-1;
                int r = in.nextInt()-1;
                int tmp = r+1;
                boolean ans = false;
                while (tmp < n) {
                    if (s.charAt(tmp) == s.charAt(r)) {
                        ans = true;
                        break;
                    }
                    tmp++;
                }
                tmp = l-1;
                while (tmp >= 0) {
                    if (s.charAt(tmp) == s.charAt(l)) {
                        ans = true;
                        break;
                    }
                    tmp--;
                }
                out.println(ans ? "YES" : "NO");
            }
        }
    }
}
