package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CUniformString {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int k = in.nextInt();
            StringBuilder sb = new StringBuilder();
            int p = 0;
            for (int i = 0; i < n; i++) {
                sb.append((char)(p+'a'));
                p = (p+1)%k;
            }

            out.println(sb.toString());

        }
    }
}
