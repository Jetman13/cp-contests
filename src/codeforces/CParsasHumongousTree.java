package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CParsasHumongousTree {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            long[][] val = new long[n+1][2];
            for (int i = 1; i <= n; i++) {
                val[i][0] = in.nextLong();
                val[i][1] = in.nextLong();
            }

            List<Integer>[] edge = new ArrayList[n+1];
            Arrays.setAll(edge,i->new ArrayList<>());
            for (int i = 0; i < n-1; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                edge[l].add(r);
                edge[r].add(l);
            }
            long[][] dp = new long[n+1][2];
            for (int i = 0; i < n+1; i++) {
                Arrays.fill(dp[i],-1);
            }
            out.println(Math.max(work(dp,edge,val,-1,1,0),work(dp,edge,val,-1,1,1)));

        }
    }

    private long work(long[][] dp, List<Integer>[] edge,long[][] val,int fa, int root, int q) {
        if (dp[root][q] != -1) {
            return dp[root][q];
        }
        long max = 0;
        for (Integer next : edge[root]) {
            if (next == fa) continue;
            max += Math.max(work(dp,edge,val,root,next,0) + Math.abs(val[root][q] - val[next][0]),work(dp,edge,val,root,next,1) + Math.abs(val[root][q] - val[next][1]));
        }
        return dp[root][q] = max;
    }
}
