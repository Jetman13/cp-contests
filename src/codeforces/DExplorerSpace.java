package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DExplorerSpace {
    Map<Long,Integer> edges;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
//        edges = new HashMap<>(n*m*2);
        int[][][] edge = new int[n+1][m+1][5];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < m; j++) {
                int v = in.nextInt();
                edge[i][j][1] = v;
                edge[i][j+1][3] = v;
//                build(i,j,i,j+1,v);
//                build(i,j+1,i,j,v);
            }
        }
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <= m; j++) {
                int v = in.nextInt();
                edge[i][j][0] = v;
                edge[i+1][j][2] = v;
//                build(i,j,i+1,j,v);
//                build(i+1,j,i,j,v);
            }
        }

        if (k%2==1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print("-1 ");
                }
                out.println();
            }
            return ;
        }

        int[][][] dp = new int[k+1][n+1][m+1];
        for (int i = 2; i <= k; i+=2) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= m; l++) {
                    dp[i][j][l] = Integer.MAX_VALUE;
                    for (int o = 0; o < 4; o++) {
                        int ni = j+dir[o][0];
                        int nj = l + dir[o][1];
                        if (ni < 1 || ni > n || nj < 1 || nj > m) continue;
//                        dp[i][j][l] = Math.min(dp[i][j][l],dp[i-2][ni][nj] + 2*get(j,l,ni,nj));
                        dp[i][j][l] = Math.min(dp[i][j][l],dp[i-2][ni][nj] + 2*edge[j][l][o]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                out.print(dp[k][i][j] + " ");
            }
            out.println();
        }


    }

    private void build(int i, int j, int i1, int j1, int v) {
        edges.put(i*1000_000_000L + j*1000_000L + i1*1000L + j1,v);
    }
    private int get(int i,int j,int i1,int j1) {
        return edges.get(i*1000_000_000L + j*1000_000L + i1*1000L + j1);
    }
}
