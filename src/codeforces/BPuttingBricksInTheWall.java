package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BPuttingBricksInTheWall {
    int[][] grid;
    int len;
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int[][] points = new int[][]{{1,0},{0,1}};
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            grid = new int[n][n];
            points = new int[][]{{1,0},{0,1},{n-1,n-2},{n-2,n-1}};
            len = n;
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    if (i+j == 0 || i+j == (n-1)+(n-1)) {
                        grid[i][j] = -1;
                    } else {
                        grid[i][j] = s.charAt(j) - '0';
                    }
                }
            }

            if (!check()) {
                out.println(0);
                continue;
            }

            for (int i = 1; i < (1<<4); i++) {
                List<Integer> list = getBit(i);
                if (list.size() > 2) continue;
                for (Integer p : list) {
                    grid[points[p][0]][points[p][1]] = 1^grid[points[p][0]][points[p][1]];
                }
                if (!check()) {
                    out.println(list.size());
                    for (Integer p : list) {
                        out.println((points[p][0] + 1) + " " + (points[p][1]+1));
                    }
                    break;
                }
                for (Integer p : list) {
                    grid[points[p][0]][points[p][1]] = 1^grid[points[p][0]][points[p][1]];
                }
            }


        }
    }

    private List<Integer> getBit(int i) {
        List<Integer> ans = new ArrayList<>();
        int j = i;
        for (int k = 0; j > 0; k++) {
            if (j%2 > 0) {
                ans.add(k);
            }
            j/=2;
        }
        return ans;
    }

    private boolean check() {
        return dfs(0,0,0,new boolean[grid.length][grid.length]) || dfs(0,0,1,new boolean[grid.length][grid.length]);
    }

    private boolean dfs(int i,int j,int k,boolean[][] flag) {
        if (i == grid.length-1 && j == grid.length-1) return true;

        flag[i][j] = true;
        boolean f = false;
        for (int t = 0; t < 4; t++) {
            int l = i + dir[t][0];
            int r = j + dir[t][1];
            if (l < len && r < len && l >=0 && r >= 0 && !flag[l][r] && (grid[l][r] == k || grid[l][r] == -1)) {
                flag[l][r] = true;
                f = dfs(l,r,k,flag);
                if (f) return true;
            }
        }
        return f;
    }
}
