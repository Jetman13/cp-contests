package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class AArrayRearrangment {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            in.readArr(a);
            in.readArr(b);

            Arrays.sort(a);
            Arrays.sort(b);
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (a[i] + b[n-i-1] > x) {
                    flag = false;
                    break;
                }
            }
            out.println(flag ? "Yes" : "No");

        }
    }
}
