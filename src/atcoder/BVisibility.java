package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BVisibility {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int h = in.nextInt();
        int w = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        char[][] grid = new char[h+2][w+2];
        for (int i = 0; i < h+2; i++) {
            Arrays.fill(grid[i],'#');
        }
        for (int i = 0; i < h; i++) {
            String str = in.nextLine();
            for (int j = 0; j < w; j++) {
                grid[i+1][j+1] = str.charAt(j);
            }
        }

        int ans = 1;
        int p = y+1;
        while (grid[x][p] == '.') {
            ans++;
            p++;
        };
        p = y-1;
        while (grid[x][p] == '.') {
            ans++;
            p--;
        }
        p = x-1;
        while (grid[p][y] == '.') {
            ans++;
            p--;
        }
        p = x+1;
        while (grid[p][y] == '.') {
            ans++;
            p++;
        }
        out.println(ans);
    }
}
