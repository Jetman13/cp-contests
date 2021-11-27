package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class I {
    int[][] dir = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] grid = new char[n+2][m+2];
        for (int i = 0; i < n+2; i++) {
            Arrays.fill(grid[i],'#');
        }
        int si = 0,sj = 0;
        for (int i = 1; i <= n; i++) {
            String str = in.nextLine();
            for (int j = 0; j < str.length(); j++) {
                grid[i][j+1] = str.charAt(j);
                if (grid[i][j+1] == '*') {
                    si = i;
                    sj = j+1;
                }
            }
        }

        int d = 0;
        int v = 0;

        int q = in.nextInt();
        String opStr = in.nextLine();
        for (int i = 0; i < q; i++) {
            char p = opStr.charAt(i);
            if (p == 'L') {
                d = (d + dir.length - 1)%dir.length;
            } else if (p == 'R'){
                d = (d+1)%dir.length;
            } else if (p == 'U') {
                v++;
            } else {
                v = Math.max(v-1,0);
            }
            
            boolean crash = false;

            done :
//            for (int j = 0; j < v; j++) {
                for (int k = 0; k < v; k++) {
                    int ni = si + dir[d][0];
                    int nj = sj + dir[d][1];
                    if (check(grid,si,sj,d)) {
                        crash = true;
                        v = 0;
                        break done;
                    }
                    si = ni;
                    sj = nj;
                }
//            }
            out.print(crash ? "Crash! " : "");
            out.println(si + " " + sj);
        }


    }

    private boolean check(char[][] grid, int si, int sj, int d) {
        int ni = si + dir[d][0];
        int nj = sj + dir[d][1];
        if (grid[ni][nj] == '#') return true;

        if (d%2 != 0) {
            if ((grid[si + dir[(d+1)%dir.length][0]][sj + dir[(d+1)%dir.length][1]] == '#') &&
            (grid[si + dir[(d+dir.length-1)%dir.length][0]][sj + dir[(d+dir.length-1)%dir.length][1]] == '#')) return true;
        }
        return false;
    }
}
