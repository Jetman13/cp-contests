package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class KGoodnessString {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
//        int t = in.nextInt();
//        for (int q = 1; q <= t; q++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.nextLine();
            int num = 0;
            for (int i = 0; i < n/2; i++) {
                if (s.charAt(i) != s.charAt(n-i-1)) num++;
            }
            out.println("Case #" + testNumber + ": "+Math.abs(num-k));
//        }
    }
}
