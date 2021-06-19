package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BMagic3 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int s = in.nextInt();
        int d = in.nextInt();
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            if (l < s && r > d) {
                ans = true;
            }
        }
        out.println(ans ? "Yes":"No");
    }
}
