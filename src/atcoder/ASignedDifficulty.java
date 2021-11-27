package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ASignedDifficulty {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        String str = in.nextLine();
        String[] sp = str.split("\\.");
        int tmp = Integer.valueOf(sp[1]);
        if (0<=tmp && tmp<=2) {
            out.println(sp[0] + "-");
        } else if (3<= tmp && tmp<=6) {
            out.println(sp[0]);
        } else {
            out.println(sp[0] + "+");
        }
    }
}
