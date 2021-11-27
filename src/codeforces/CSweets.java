package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CSweets {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int k = in.nextInt();
            StringBuilder sb = new StringBuilder(in.nextLine());
            int like = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '1') {
                    like++;
                }
            }

            int num = 0;
            int p = 0;
            while (like > 0) {
                if (sb.charAt(p) == '1') {
                    like--;
                }
                num++;
                sb.deleteCharAt(p);
                if (sb.length() == 0) break;
                if (p == sb.length()) {
                    p = 0;
                }
                p = (p+k-1)%sb.length();
            }
            out.println(num);

        }
    }
}
