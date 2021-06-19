package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class BConstructTheString {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            StringBuilder sb = new StringBuilder();
            int s = 0;
            for (int i = 0; i < n; i++) {
                sb.append((char)('a'+s));
                s = (s+1)%b;
            }
            out.println(sb.toString());
        }
    }
}
