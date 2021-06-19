package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class DHanjo {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int h = in.nextInt();
        int w = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int[][] map = new int[h+2][w+2];
        int ans = 0;
        for (int i = 0; i < (1<<(h*w)); i++) {
            int one = 0;
            for (int j = 0; j < (h*w); j++) {
                int k = (i&(1<<j)) > 0 ? 1 : 0;
                int l = j/w + 1;
                int r = j%w + 1;
                map[l][r] = k;
                if (k == 1) one++;
            }
            if (one != a*2) continue;

            if (check(map)) ans++;

        }
        out.println(ans);
    }

    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    class Node {
        int l;
        int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    private boolean check(int[][] map) {
        Queue<Node> q = new LinkedList<>();
        int h = map.length-2;
        int w = map[0].length-2;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (map[i][j] == 0) continue;
                int num = getNum(map, i, j);
                if (num == 0) return false;
                if (num == 1) {
                    q.offer(new Node(i,j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (map[node.l][node.r] == 0) continue;
            for (int i = 0; i < 4; i++) {
                int ni = node.l + dir[i][0];
                int nj = node.r + dir[i][1];
                if (map[ni][nj] == 1) {
                    map[node.l][node.r] = 0;
                    map[ni][nj] = 0;
                    for (int j = 0; j < 4; j++) {
                        int nni = ni + dir[i][0];
                        int nnj = nj + dir[i][1];
                        if (map[nni][nnj] == 1 && getNum(map,nni,nnj) == 1) {
                            q.offer(new Node(nni,nnj));
                        }
                    }
                }
            }
        }
        return true;
    }

    private int getNum(int[][] map, int i, int j) {
        int num = 0;
        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            if (map[ni][nj] == 1) num++;
        }
        return num;
    }
}
