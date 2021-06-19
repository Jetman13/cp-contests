package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BBallsOfSteel {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
            }

            boolean ans = false;
            for (int i = 0; i < n; i++) {
                int tmp = 0;
                for (int j = 0; j < n; j++) {
                    if (dis(a,i,j) <= k) tmp++;
                }
                if (tmp == n) {
                    ans = true;
                    break;
                }
            }
            out.println(ans ? 1 : -1);

        }
    }

    private int dis(int[][] a, int i, int j) {
        return Math.abs(a[i][0] - a[j][0]) + Math.abs(a[i][1] - a[j][1]);
    }
}
