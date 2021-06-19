package codeforces;

import java.util.LinkedList;
import java.util.Queue;

public class TheQuestForGold {
    class Node {
        int l;
        int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public String explore(String[] cave) {
        int n = cave.length;
        int m = cave[0].length();
        int[][] map = new int[n+2][m+2];

        int si = 0;
        int sj = 0;
        int ti = -1;
        int tj = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cave[i].charAt(j) == 'S') {
                    si = i;
                    sj = j;
                }
                if (cave[i].charAt(j) == 'T') {
                    ti = i;
                    tj = j;
                }
            }
        }


        Queue<Node> q = new LinkedList<>();

        if (check(si,sj,cave,map)) {
            q.offer(new Node(si, sj));
            map[si][sj] = 1;
        }
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int l = node.l + dir[i][0];
                int r = node.r + dir[i][1];
                if (check(l,r,cave,map)) {
                    map[l][r] = 1;
                    q.offer(new Node(l,r));
                }
            }
        }

        if (ti == -1) {
            return "no gold";
        }
        return map[ti][tj] == 1 ? "gold":"no gold";
    }

    private boolean check(int l, int r, String[] cave,int[][] map) {
        int n = cave.length;
        int m = cave[0].length();
        if (l < 0 || l >= n || r < 0 || r >= m) return false;
        if (map[l][r] == 1) return false;
        if (cave[l].charAt(r) == 'P') return false;
        map[l][r] = 1;

        for (int i = 0; i < 4; i++) {
            int nl = l + dir[i][0];
            int nr = r + dir[i][1];
            if (nl < 0 || nl >= n || nr < 0 || nr >= m) continue;
            if (cave[nl].charAt(nr) == 'P') return false;
        }
        return true;
    }
}
