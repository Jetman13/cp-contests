package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Checksum {
    class Node {
        int l;
        int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }
        int[][] val = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                val[i][j] = in.nextInt();
            }
        }
        int[] xorr = new int[n+1];
        int[] xorc = new int[n+1];
        for (int i = 0; i < n; i++) {
            xorr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            xorc[i] = in.nextInt();
        }

        List<Node> ukList = relax(map);
        if (ukList.size() == 0) {
            out.println("Case #" + testNumber + ": 0");
            return;
        }

        long ans = Long.MAX_VALUE;
        int size = ukList.size();
        for (int i = 0; i < (1<<size); i++) {
            int[][] copy = copy(map);
            long fee = 0;
            for (int j = 0; j < size; j++) {
                if (((1<<j)&i) > 0) {
                    fee += val[ukList.get(j).l][ukList.get(j).r];
                    copy[ukList.get(j).l][ukList.get(j).r] = 1;
                }
            }
            if (relax(copy).size() == 0) {
                ans = Math.min(ans,fee);
            }
        }

        out.println("Case #" + testNumber + ": "+ans);

    }

    private int[][] copy(int[][] map) {
        int[][] c = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                c[i][j] = map[i][j];
            }
        }
        return c;
    }

    private List<Node> relax(int[][] map) {
        int n = map.length;
        int[] ukr = new int[n];
        int[] ukc = new int[n];
        int uk = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1) ukr[i]++;
                if (map[j][i] == -1) ukc[i]++;
                if (map[i][j] == -1) uk++;
            }
        }

        while (true) {
            boolean f = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == -1 && (ukr[i] == 1 || ukc[j] == 1)) {
                        map[i][j] = 2;
                        ukr[i]--;
                        ukc[j]--;
                        uk--;
                        f = true;
                    }
                }
            }
            if (!f) break;
        }

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] == -1) {
                    list.add(new Node(i,j));
                }
            }
        }
        
        return list;
    }
}
