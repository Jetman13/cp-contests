package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class SeekTheJokerI {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (n == 1) {
                out.println("ma la se mi no.1!");
                continue;
            }
            if (k >= n-1) {
                out.println("yo xi no forever!");
                continue;
            }


            out.println(n%(k+1) != 1 ? "yo xi no forever!":"ma la se mi no.1!");
        }
    }
}
