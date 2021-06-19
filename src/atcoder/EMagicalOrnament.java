package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EMagicalOrnament {
    Set<Long> set;
    long TMP = 1000000L;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        set = new HashSet<>();
        boolean[] flag = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            flag[(int)a] = true;
            flag[(int)b] = true;
            set.add(a * TMP + b);
            set.add(b * TMP + a);
        }
        int k = in.nextInt();
        int[] c = new int[k];
        in.readArr(c);

        if (k == 1) {
            out.println(flag[c[0]] ? "1" : -1);
            return ;
        }

        int[] dp = new int[(1<<k)];
        dp[0] = 0;
        for (int i = 1; i < (1<<k); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                if (((1<<j)&i) == 0) continue;
                list.add(j);
            }

            if (list.size() == 1) {
                if (flag[c[list.get(0)]]) {
                    dp[i] = 1;
                }
                continue;
            }
            if (list.size() == 2) {
                dp[i] = (int)TMP;
                int ll = list.get(0);
                int rr = list.get(1);
                if (set.contains(c[ll]*TMP + c[rr])) {
                    dp[i] = 1;
                }
                continue;
            }

            dp[i] = (int)TMP;
            for (int j = 0; j < list.size(); j++) {
                int min = (int)TMP;
                for (int l = 0; l < list.size(); l++) {
                    if (j == l) continue;
                    int ll = list.get(j);
                    int rr = list.get(l);
                    if (!set.contains(c[ll]*TMP + c[rr])) continue;

                    min = Math.min(min,dp[i^(1<<ll)] + 1);
                }
                dp[i] = Math.min(min,dp[i]);
            }

        }

        out.println(dp[(1<<k)-1] == TMP ? "-1" : dp[(1<<k)-1]);


    }
}
