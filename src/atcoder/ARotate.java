package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ARotate {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();
        out.println(s.substring(1) + s.charAt(0));
    }
}
