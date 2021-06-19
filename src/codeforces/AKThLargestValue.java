package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AKThLargestValue {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n+1];
        int one = 0;
        for (int i = 1; i <= n ; i++) {
            a[i] = in.nextInt();
            if (a[i] == 1) one++;
        }

        for (int i = 0; i < q; i++) {
            int k = in.nextInt();
            int val = in.nextInt();
            if (k == 1) {
                a[val] = 1-a[val];
                if (a[val] == 1) {
                    one++;
                } else {
                    one--;
                }
            } else {
                if (one >= val) {
                    out.println(1);
                } else {
                    out.println(0);
                }
            }
        }
    }
}
