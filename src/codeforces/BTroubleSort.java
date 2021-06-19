package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BTroubleSort {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            in.readArr(a);
            in.readArr(b);
            boolean[] flag = new boolean[2];
            boolean f = true;
            for (int i = 0; i < n; i++) {
                if (i != 0 && a[i] < a[i-1]) {
                    f = false;
                }
                flag[b[i]] = true;
            }
            if ((flag[0] && flag[1]) || f) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
    }
}
