package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ACompetition {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        int ans = (int)((double)y/x * (double)z);

        if (ans*x == y*z) ans--;

        out.println((int)ans);

    }
}
