package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BHardCalculation {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String a = in.next();
        String b = in.next();
        boolean easy = true;
        int i = a.length()-1;
        int j = b.length()-1;
        for (;i>=0&&j>=0;i--,j--) {
            if (a.charAt(i) - '0' + b.charAt(j) - '0' > 9) {
                easy = false;
                break;
            }
        }
        out.println(easy ? "Easy":"Hard");
    }
}
