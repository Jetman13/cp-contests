package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AMatrixGame {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean[] col = new boolean[m];
            boolean[] row = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int tmp = in.nextInt();
                    if (tmp == 1) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }
            int r = 0;
            for (int i = 0; i < n; i++) {
                if (!row[i]) r++;
            }
            int c = 0;
            for (int i = 0; i < m; i++) {
                if (!col[i]) c++;
            }
            int min = Math.min(r,c);
            if (min%2 == 0) {
                out.println("Vivek");
            } else {
                out.println("Ashish");
            }
        }
    }
}
