package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class EStrongerTakahashi {
    class Node {
        int l,r;
        int val;

        public Node(int l, int r, int val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int h,w;
    int[][] dp;
    char[][] hw;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        h = in.nextInt();
        w = in.nextInt();

        hw = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = in.nextLine();
            for (int j = 0; j < w; j++) {
                hw[i][j] = s.charAt(j);
            }
        }

        dp = new int[h+1][w+1];
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;
        Queue<Node> q = new PriorityQueue<>((aa,bb)->aa.val-bb.val);
        q.add(new Node(0,0,0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            List<Node> list = bfs(node.l, node.r, dp[node.l][node.r]);
            for (Node node1 : list) {
                q.offer(node1);
            }

            for (int j = -2; j <= 2 ; j++) {
                for (int k = -2; k <= 2 ; k++) {
                    if (Math.abs(j) == 2 && Math.abs(k) == 2) continue;
                    int ni = node.l + j;
                    int nj = node.r + k;
                    if (checkNo(ni,nj)) continue;
                    if (dp[ni][nj] != -1) continue;
                    if (hw[ni][nj] == '.') continue;
                    dp[ni][nj] = dp[node.l][node.r] + 1;
                    q.offer(new Node(ni,nj,dp[ni][nj]));
                }
            }

        }

        out.println(dp[h-1][w-1]);


    }

    private List<Node> bfs(int ll, int rr, int val) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(ll,rr,val));
        List<Node> list = new ArrayList<>();
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int l = node.l + dir[i][0];
                int r = node.r + dir[i][1];
                if (checkNo(l,r)) continue;
                if (dp[l][r] != -1) continue;
                if (hw[l][r] == '.') {
                    dp[l][r] = dp[node.l][node.r];
                    q.offer(new Node(l,r,dp[l][r]));
                    list.add(new Node(l,r,dp[l][r]));
                }
            }
        }
        return list;
    }

    private boolean checkNo(int l, int r) {
        if (l < 0 || l >= h) return true;
        if (r < 0 || r >= w) return true;
        return false;
    }
}
