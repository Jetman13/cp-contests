package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BThreeCorners {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int a0 = in.nextInt();
            int a1 = in.nextInt();
            int b0 = in.nextInt();
            int b1 = in.nextInt();
            int c0 = in.nextInt();
            int c1 = in.nextInt();

            int[] a = new int[]{a0,b0,c0};
            Arrays.sort(a);
            int[] b = new int[]{a1,b1,c1};
            Arrays.sort(b);

            out.println(cal(a) + " " + cal(b));

        }
    }

    private int cal(int[] a) {
        if (a[0] == a[1]) return a[2];
        if (a[1] == a[2]) return a[0];
        return -1;
    }
}
