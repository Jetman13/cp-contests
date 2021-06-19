package atcoder;

import tool.FastReader;
import tool.Pair;

import java.io.PrintWriter;

public class AHands {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int ans = x + Math.abs(a-b)*y;
        if (a > b) {
            ans = Math.min(ans,x+Math.abs(a-b-1)*y);
            ans = Math.min(ans,(Math.abs(a-b)*2-1)*x);
        } else if (a < b) {
            ans = Math.min(ans,(Math.abs(a-b)*2+1)*x);
        } else if (a == b) {
            ans = Math.min(ans,x);
        }
        out.println(ans);
    }
}
