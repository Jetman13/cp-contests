package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CTriangles {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String[] grid = new String[n];
            int[][] max = new int[10][4];
            for (int i = 0; i < max.length; i++) {
                max[i] = new int[]{n,0,0,n};
            }
            int[][][] row = new int[n+1][10][2];
            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < 10; j++) {
                    row[i][j] = new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
                }
            }
            int[][][] col = new int[n+1][10][2];
            for (int i = 0; i < col.length; i++) {
                for (int j = 0; j < 10; j++) {
                    col[i][j] = new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
                }
            }
            for (int i = 0; i < n; i++) {
                grid[i] = in.nextLine();
                for (int j = 0; j < grid[i].length(); j++) {
                    int k = grid[i].charAt(j) - '0';
                    max[k][0] = Math.min(max[k][0],i);
                    max[k][1] = Math.max(max[k][1],j);
                    max[k][2] = Math.max(max[k][2],i);
                    max[k][3] = Math.min(max[k][3],j);

                    row[i][k][0] = Math.min(row[i][k][0],j);
                    row[i][k][1] = Math.max(row[i][k][0],j);

                    col[j][k][0] = Math.min(col[j][k][0],i);
                    col[j][k][1] = Math.max(col[j][k][1],i);

                }
            }

            for (int i = 0; i < 10; i++) {
                int ans = 0;
                for (int r = 0; r < n; r++) {
                    if (row[r][i][0] == Integer.MAX_VALUE && row[r][i][1] == Integer.MIN_VALUE) continue;
                    int tmp = row[r][i][1] - row[r][i][0];
                    ans = Math.max(ans,tmp*r);
                    ans = Math.max(ans,tmp*(n-r-1));
                    int maxrow = Math.max(n - row[r][i][0] - 1,row[r][i][1]);
                    ans = Math.max(ans,maxrow*(r-max[i][0]));
                    ans = Math.max(ans,maxrow*(max[i][2]-r));
                }

                for (int c = 0; c < n; c++) {
                    if (col[c][i][0] == Integer.MAX_VALUE && col[c][i][1] == Integer.MIN_VALUE) continue;
                    int tmp = col[c][i][1] - col[c][i][0];
                    ans = Math.max(ans,tmp*c);
                    ans = Math.max(ans,tmp*(n-c-1));
                    int maxrow = Math.max(n - col[c][i][0] - 1,col[c][i][1]);
                    ans = Math.max(ans,maxrow*(max[i][1]-c));
                    ans = Math.max(ans,maxrow*(c-max[i][3]));
                }
                out.print(ans + " ");
            }
            out.println();

        }
    }
}
