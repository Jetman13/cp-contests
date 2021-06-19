package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ASlot {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        String str = in.nextLine();
        boolean flag = true;
        for (int i = 1; i < 3; i++) {
            if (str.charAt(i) != str.charAt(0)) {
                flag = false;
            }
        }
        out.println(flag ? "Won":"Lost");
    }
}
