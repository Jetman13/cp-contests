package facebook;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BXsAndOs {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.nextLine().toCharArray();
        }
        int[] num = new int[n+1];
        Arrays.fill(num,-1);
        for (int i = 0; i < n; i++) {
            int tmp = getRow(i,grid);
            if (tmp != -1) {
                num[tmp]++;
            }
        }

        for (int i = 0; i < n; i++) {
            int tmp = getCol(i,grid);
            if (tmp != -1) {
                num[tmp]++;
            }
        }

        for (int i = 0; i <= n; i++) {
            if (num[i] != -1) {
                out.println("Case #" + testNumber + ": " + i + " " + (num[i]+1));
                return ;
            }
        }
        out.println("Case #" + testNumber + ": Impossible");


    }

    private int getCol(int i, char[][] grid) {
        int num = 0;
        for (int j = 0; j < grid.length; j++) {
            if (grid[j][i] == 'O') return -1;
            if (grid[j][i] == 'X') continue;
            num++;
        }
        return num;
    }

    private int getRow(int i, char[][] grid) {
        int num = 0;
        int flag = 0;
        for (int j = 0; j < grid.length; j++) {
            if (grid[i][j] == 'O') return -1;
            if (grid[i][j] == 'X') continue;
            flag = j;
            num++;
        }

        if (num == 1) {
            if (getCol(flag,grid) == 1) return -1;
        }

        return num;
    }
}
