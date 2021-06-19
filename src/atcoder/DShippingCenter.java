package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DShippingCenter {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        int[][] w = new int[n][2];
        for (int i = 0; i < n; i++) {
            w[i][0] = in.nextInt();
            w[i][1] = in.nextInt();
        }

        int[] x = new int[m];
        in.readArr(x);

        for (int i = 0; i < q; i++) {
            List<Integer> list = new ArrayList<>();
            int l = in.nextInt()-1;
            int r = in.nextInt()-1;
            for (int j = 0; j < l ; j++) {
                list.add(x[j]);
            }
            for (int j = r+1; j < m ; j++) {
                list.add(x[j]);
            }

            if (list.size() == 0) {
                out.println(0);
                continue;
            }
            list.sort(Comparator.naturalOrder());

            long ans = 0;
            boolean[] f = new boolean[51];
            long num = 0;
            for (Integer xx : list) {
                int max = -1;
                int p = -1;
                for (int j = 0; j < n; j++) {
                    if (xx >= w[j][0] && !f[j]) {
                        if (max < w[j][1]) {
                            max = w[j][1];
                            p = j;
                        }
                    }
                }
                if (max != -1) {
                    num++;
                    ans+=max;
                    f[p] = true;
                }
            }
            out.println(ans);

        }
    }
}
