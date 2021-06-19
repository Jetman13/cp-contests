package atcoder;


import tool.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int ax,ay,bx,by;

    public Node(int ax, int ay, int bx, int by) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
    }
}

public class TwoRobots {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int move(String[] plan) {
        Pair<Integer,Integer> A = null,B = null,a = null,b = null;
        for (int i = 0; i < plan.length; i++) {
            for (int j = 0; j < plan[0].length(); j++) {
                char ch = plan[i].charAt(j);
                if (ch == 'A') {
                    A = new Pair<>(i,j);
                } else if (ch == 'B') {
                    B = new Pair<>(i,j);
                } else if (ch == 'a') {
                    a = new Pair<>(i,j);
                } else if (ch == 'b') {
                    b = new Pair<>(i,j);
                }
            }
        }

        int w = plan.length;
        int h = plan[0].length();
        int[][][][] dp = new int[w+1][h+1][w+1][h+1];
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= h ; j++) {
                for (int k = 0; k <= w ; k++) {
                    Arrays.fill(dp[i][j][k],10002);
                }
            }
        }

        dp[A.getKey()][A.getValue()][B.getKey()][B.getValue()] = 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(A.getKey(),A.getValue(),B.getKey(),B.getValue()));
        while (q.size() > 0) {
            Node node = q.poll();
            if (check(node,a,b)) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nax = node.ax + dir[i][0];
                int nay = node.ay + dir[i][1];
                if (out(nax,nay,plan)) continue;
                for (int j = 0; j < 4; j++) {
                    int nbx = node.bx + dir[j][0];
                    int nby = node.by + dir[j][1];
                    if (out(nbx,nby,plan)) continue;
                    if (nax == nbx && nay == nby) continue;
                    if (nax == node.bx && nay == node.by && nbx == node.ax && nby == node.ay) continue;
                    if (dp[nax][nay][nbx][nby] != 10002) continue;
                    dp[nax][nay][nbx][nby] = dp[node.ax][node.ay][node.bx][node.by] + 1;
                    q.offer(new Node(nax,nay,nbx,nby));
                }
            }
        }
        return dp[a.getKey()][a.getValue()][b.getKey()][b.getValue()] == 10002 ? -1 : dp[a.getKey()][a.getValue()][b.getKey()][b.getValue()];
    }

    private boolean out(int nax, int nay, String[] plan) {
        if (nax < 0 || nay < 0 || nax >= plan.length || nay >= plan[0].length()) return true;
        if (plan[nax].charAt(nay) == '#') return true;
        return false;
    }

    private boolean check(Node node, Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        if ((node.ax == a.getKey()) && (node.ay == a.getValue()) && (node.bx == b.getKey()) && (node.by == b.getValue())) return true;
        return false;
    }
}
