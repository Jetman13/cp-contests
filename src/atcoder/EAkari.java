package atcoder;

import tool.FastReader;
import tool.RangeTree;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class EAkari {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int h = in.nextInt();
        int w = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] bulbs = new int[n][2];
        int[][] grid = new int[h+1][w+1];
        for (int i = 0; i < n; i++) {
            bulbs[i][0] = in.nextInt();
            bulbs[i][1] = in.nextInt();
            grid[bulbs[i][0]][bulbs[i][1]] = 1;
        }
        List<Integer>[] brow = new ArrayList[h+1];
        List<Integer>[] bcol = new ArrayList[w+1];
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            grid[l][r] = -1;
            if (brow[l] == null) brow[l] = new ArrayList<>();
            if (bcol[r] == null) bcol[r] = new ArrayList<>();
            brow[l].add(r);
            bcol[r].add(l);
        }
        for (int i = 0; i <= h; i++) {
            if (brow[i] != null) {
                Collections.sort(brow[i]);
            }
        }
        for (int i = 0; i <= w; i++) {
            if (bcol[i] != null) {
                Collections.sort(bcol[i]);
            }
        }

        RangeTree rth = new RangeTree(h*w+2);
        RangeTree rtw = new RangeTree(h*w+2);
        int[][] gridh = new int[h+1][w+2];
        int[][] gridw = new int[w+1][h+2];
        for (int i = 0; i < n; i++) {
            {
                int l = 1;
                int r = w;
                if (brow[bulbs[i][0]] != null) {
                    int index = -Collections.binarySearch(brow[bulbs[i][0]],bulbs[i][1]) - 1;
                    if (index > 0) {
                        l = brow[bulbs[i][0]].get(index-1)+1;
                    }
                    if (index < brow[bulbs[i][0]].size()) {
                        r = brow[bulbs[i][0]].get(index)-1;
                    }
                }
                gridh[bulbs[i][0]][l] = 1;
                gridh[bulbs[i][0]][r+1] = -1;
//                rth.update((bulbs[i][0]-1)*w + l,(bulbs[i][0]-1)*w + r,1);
            }
            {
                int l = 1;
                int r = h;
                if (bcol[bulbs[i][1]] != null) {
                    int index = -Collections.binarySearch(bcol[bulbs[i][1]],bulbs[i][0]) - 1;
                    if (index > 0) {
                        l = bcol[bulbs[i][1]].get(index-1)+1;
                    }
                    if (index < bcol[bulbs[i][1]].size()) {
                        r = bcol[bulbs[i][1]].get(index)-1;
                    }
                }
                gridw[bulbs[i][1]][l] = 1;
                gridw[bulbs[i][1]][r+1] = -1;
//                rtw.update((bulbs[i][1]-1)*h + l,(bulbs[i][1]-1)*h + r,1);
            }
        }

        for (int i = 1; i <= h; i++) {
            int num = 0;
            for (int j = 1; j <= w ; j++) {
                num += gridh[i][j];
                if (num > 0) {
                    grid[i][j] = 1;
                }
            }
        }
        for (int i = 1; i <= w; i++) {
            int num = 0;
            for (int j = 1; j <= h ; j++) {
                num += gridw[i][j];
                if (num > 0) {
                    grid[j][i] = 1;
                }
            }
        }


        int ans = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w ; j++) {
                if (grid[i][j] == -1) continue;
                if (grid[i][j] == 1) {
                    ans++;
                    continue;
                }
//                if (rth.minQuery((i-1)*w + j,(i-1)*w + j) > 0) {
//                    ans++;
//                } else if (rtw.minQuery((j-1)*h + i,(j-1)*h + i) > 0) {
//                    ans++;
//                }
            }
        }
        out.println(ans);

    }
}
