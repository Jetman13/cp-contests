package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AFavoriteSequence {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            int[] ans = new int[n];
            int l = 0;
            int r = n-1;
            int index = 0;
            int bit = 0;
            while (index < n) {
                if (bit == 0) {
                    ans[index++] = a[l++];
                } else {
                    ans[index++] = a[r--];
                }
                bit^=1;
            }
            for (int i = 0; i < n; i++) {
                out.print(ans[i] + " ");
            }
        }
    }
}
