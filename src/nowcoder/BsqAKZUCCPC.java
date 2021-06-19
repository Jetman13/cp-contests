package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BsqAKZUCCPC {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long m = in.nextLong();
            long[] a = new long[(int)n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }

            long min = Arrays.stream(a).min().getAsLong();
            long max = Arrays.stream(a).max().getAsLong();
            long sum = Arrays.stream(a).sum();
            long lost = n*m - sum;
            out.println(Math.max(0,m-lost) + " " + min);
            out.println(Math.max(0,m-sum) + " " + (m-max));

        }
    }
}
