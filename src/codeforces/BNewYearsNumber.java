package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BNewYearsNumber {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();

            boolean ans = false;
            for (int i = 0; i*2020 <= n ; i++) {
                if ((n - i*2020)%2021 == 0) {
                    ans = true;
                    break;
                }
            }
            out.println(ans ? "YES":"NO");

        }
    }
}
