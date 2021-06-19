package codeforces;

import net.egork.chelper.task.Test;
import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class GToGoOrNotToGo {
    class Node {
        int l,r;
        long val;

        public Node(int l, int r, long val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long w = in.nextInt();

        long[][] grid = new long[n+2][m+2];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i],-1);
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                grid[i][j] = in.nextLong();
            }
        }

        long[][] sdis = new long[n+2][m+2];
        long[][] edis = new long[n+2][m+2];
        bfs(1,1,sdis,grid,w);
        bfs(n,m,edis,grid,w);
        long ans = Long.MAX_VALUE;
        if (sdis[n][m] != -1) {
            ans = sdis[n][m];
        }

        Node lnode = getNode(sdis,grid);
        Node rnode = getNode(edis,grid);
        if (lnode!=null && rnode!=null) {
            ans = Math.min(ans,lnode.val+rnode.val);
        }
        out.println(ans == Long.MAX_VALUE ? -1 : ans);

    }

    private Node getNode(long[][] dis, long[][] grid) {
        Node min = null;
        for (int i = 1; i < dis.length-1; i++) {
            for (int j = 1; j < dis[0].length-1; j++) {
                if (dis[i][j] >= 0 && grid[i][j] > 0) {
                    if (min == null) {
                        min = new Node(i,j,dis[i][j] + grid[i][j]);
                    } else {
                        if (min.val > dis[i][j] + grid[i][j]) {
                            min = new Node(i,j,dis[i][j] + grid[i][j]);
                        }
                    }

                }
            }
        }
        return min;
    }

    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private void bfs(int i, int j, long[][] dis, long[][] grid, long w) {
        for (int k = 0; k < dis.length; k++) {
            Arrays.fill(dis[k],-1);
        }
        Queue<Node> q = new LinkedList<>();
        dis[i][j] = 0;
        q.offer(new Node(i,j,0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int k = 0; k < 4; k++) {
                int l = node.l + dir[k][0];
                int r = node.r + dir[k][1];
                if (l == i && r == j) continue;
                if (grid[l][r] == -1) continue;
                if (dis[l][r] > 0) continue;
                dis[l][r] = node.val + w;
                q.offer(new Node(l,r,dis[l][r]));
            }
        }

    }
}
