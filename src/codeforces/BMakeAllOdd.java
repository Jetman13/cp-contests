package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BMakeAllOdd {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            int num = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0) {
                    num++;
                }
            }

            out.println(num == n ? "-1" : num);
        }
    }
}
