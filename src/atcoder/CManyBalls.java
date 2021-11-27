package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CManyBalls {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            if (n%2==0) {
                n/=2;
                ans.append("B");
            } else {
                n--;
                ans.append("A");
            }
        }
        out.println(ans.reverse().toString());
    }
}
