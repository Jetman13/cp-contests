package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ETraveler {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        List<Long>[] map = new ArrayList[n];
        Arrays.setAll(map,i->new ArrayList<>());
        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            int c = in.nextInt()-1;
            map[c].add(x);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(map[i]);
        }

        long[] dp = new long[2];
        long[] val = new long[2];
        for (int i = 0; i < n; i++) {
            if (map[i].size() == 0) continue;
            List<Long> list = map[i];
            long sum = list.get(list.size()-1) - list.get(0);
            long[] ndp = new long[2];
            ndp[0] = dp[0] + sum + Math.abs(val[0] - list.get(list.size()-1));
            ndp[0] = Math.min(ndp[0],dp[1] + sum + Math.abs(val[1] - list.get(list.size()-1)));
            ndp[1] = dp[1] + sum + Math.abs(val[1] - list.get(0));
            ndp[1] = Math.min(ndp[1],dp[0] + sum + Math.abs(val[0] - list.get(0)));

            dp = ndp;
            val[0] = list.get(0);
            val[1] = list.get(list.size()-1);
        }

        out.println(Math.min(dp[0] + Math.abs(val[0]),dp[1] + Math.abs(val[1])));


    }
}
