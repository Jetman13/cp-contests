package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BinarizeIt {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int p = 1;
            int tmp = in.nextInt();
            while (p < tmp) p*=2;
            out.println("Input value: "+tmp);
            out.println(p);
            out.println();
        }
    }
}
