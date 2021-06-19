package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BTwoArraysAndSwaps {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            in.readArr(a);
            in.readArr(b);

            Arrays.sort(a);
            Arrays.sort(b);

            for (int i = 0; i < k; i++) {
                if (a[i] < b[n-i-1]) {
                    a[i] = b[n-i-1];
                }
            }
            out.println(Arrays.stream(a).sum());

        }
    }
}
