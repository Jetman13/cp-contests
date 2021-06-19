package nowcoder;

import tool.FastReader;
import tool.Pair;

import java.io.PrintWriter;

public class Wzc {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[][] grid = new int[n][n];
            String s = in.nextLine();
            int l = 0;
            int r = 0;
            grid[l][r] = 1;
            int num = 2;
            for (int i = 0; i < s.length(); i++) {
                char op = s.charAt(i);
                if (op == 'w') {
                    l--;
                } else if (op == 'a') {
                    r--;
                } else if (op == 's') {
                    l++;
                } else {
                    r++;
                }
                grid[l][r] = num++;
            }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(grid[i][j] + " ");
            }
            out.println();
        }
        out.println();
        }
    }
}
