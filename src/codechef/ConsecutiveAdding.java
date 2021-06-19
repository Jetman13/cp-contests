package codechef;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.List;

public class ConsecutiveAdding {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int r = in.nextInt();
            int c = in.nextInt();
            int x = in.nextInt();
            long[][] a = new long[r][c];
            in.readArr(a);
            long sum = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j]-=in.nextLong();
                    sum+=a[i][j];
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j+x-1 < c; j++) {
                    long tmp = a[i][j];
                    for (int k = 0; k < x; k++) {
                        a[i][j+k]-=tmp;
                        sum-=tmp;
                    }
                }
            }

            for (int j = c-x; j < c; j++) {
                for (int i = 0; i+x-1 < r; i++) {
                    long tmp = a[i][j];
                    for (int k = 0; k < x; k++) {
                        a[i+k][j]-=tmp;
                        sum-=tmp;
                    }
                }
            }
            boolean f = true;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (a[i][j] != 0) {
                        f = false;
                    }
                }
            }
            out.println(f ? "Yes":"No");


        }
    }
}
