package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CBowlsAndDishes {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] a = new int[m][2];
        in.readArr(a);

        int k = in.nextInt();
        int[][] c = new int[k][2];
        in.readArr(c);

        int ans = 0;
        for (int i = 0; i < (1<<k); i++) {
            int num = 0;
            boolean[] flag = new boolean[n+1];
            for (int j = 0; j < k; j++) {
                if (((1<<j)&i) == 0) {
                    flag[c[j][0]] = true;
                } else {
                    flag[c[j][1]] = true;
                }

            }

            for (int j = 0; j < m; j++) {
                if (flag[a[j][0]] && flag[a[j][1]]) num++;
            }
            ans = Math.max(ans,num);
        }
        out.println(ans);

    }
}
