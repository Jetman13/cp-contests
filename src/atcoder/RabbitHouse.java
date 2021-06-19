package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class RabbitHouse {
    class Node {
        int l;
        int r;
        int val;

        public Node(int l, int r, int val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] map = new int[r+2][c+2];
        for (int i = 0; i < r+2; i++) {
            Arrays.fill(map[i],-1);
        }
        Queue<Node> q = new PriorityQueue<>((aa,bb)->bb.val-aa.val);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i+1][j+1] = in.nextInt();
                q.offer(new Node(i+1,j+1,map[i+1][j+1]));
            }
        }
        boolean[][] f = new boolean[r+2][c+2];
        long ans = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (f[node.l][node.r]) continue;
            f[node.l][node.r] = true;
            for (int i = 0; i < 4; i++) {
                int nl = node.l + dir[i][0];
                int nr = node.r + dir[i][1];
                if (map[nl][nr] == -1) continue;
                if (map[nl][nr] < map[node.l][node.r]) {
                    ans += map[node.l][node.r] - map[nl][nr] - 1;
                    map[nl][nr] = map[node.l][node.r]-1;
                    q.offer(new Node(nl,nr,map[nl][nr]));
                }
            }
        }

        out.println("Case #" + testNumber + ": "+ans);

    }
}
