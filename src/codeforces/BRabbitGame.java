package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BRabbitGame {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);

        int lnum = 0;
        int pre = -1;
        while (lnum < n && a[lnum] >= pre) {
            pre = a[lnum];
            lnum++;
        }
        int rnum = n-1;
        pre = -1;
        while (rnum >= 0 && a[rnum] >= pre) {
            pre = a[rnum];
            rnum--;
        }
        int ans = lnum + n - rnum - 1;

        out.println(ans > n ? n : ans);

    }
}
