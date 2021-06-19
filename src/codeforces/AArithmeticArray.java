package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AArithmeticArray {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            int sum = Arrays.stream(a).sum();

            int ans = 0;
            while (sum != n) {
                if (sum > n) {
                    ans += sum - n;
                    break;
                } else {
                    ans ++;
                    break;
                }
            }
            out.println(ans);

        }
    }
}
