package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CNotAdjacentMatrix {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            int p = 1;
            if (n == 2) {
                out.println(-1);
                continue;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i+j)%2==0) {
                        a[i][j] = p++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i+j)%2==1) {
                        a[i][j] = p++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(a[i][j] + " ");
                }
                out.println();
            }
        }
    }
}
