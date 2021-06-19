package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BAtCoderCondominium {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                sum += Long.valueOf(i + "0" + j);
            }
        }
        out.println(sum);
    }
}
