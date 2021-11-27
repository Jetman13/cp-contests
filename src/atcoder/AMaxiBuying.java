package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AMaxiBuying {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int tmp = (int)(n * 1.08);
        if (tmp > 206) {
            out.println(":(");
        } else if (tmp < 206){
            out.println("Yay!");
        } else {
            out.println("so-so");
        }
    }
}
