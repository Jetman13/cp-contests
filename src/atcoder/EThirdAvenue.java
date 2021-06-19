package atcoder;

import tool.*;

import java.io.PrintWriter;
import java.util.*;

public class EThirdAvenue {

    class Node {
        int l;
        int r;
        int n;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
            this.n = 0;
        }

        public Node(int l, int r, int n) {
            this.l = l;
            this.r = r;
            this.n = n;
        }
    }

    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int h = in.nextInt();
        int w = in.nextInt();
        char[][] grid = new char[h+2][w+2];

        Arrays.fill(grid[0],'#');
        Arrays.fill(grid[h+1],'#');
        List<Node>[] let = new ArrayList[30];
        for (int i = 0; i < let.length; i++) {
            let[i] = new ArrayList<>();
        }
        int si = 0,sj = 0;
        for (int i = 1; i <= h; i++) {
            String str = in.nextLine();
            Arrays.fill(grid[i],'#');
            for (int j = 1; j <= w; j++) {
                grid[i][j] = str.charAt(j-1);
                if (str.charAt(j-1) == 'S') {
                    si = i;
                    sj = j;
                } else if (str.charAt(j-1) >= 'a' && str.charAt(j-1) <= 'z') {
                    let[str.charAt(j-1) - 'a'].add(new Node(i,j));
                }
            }
        }


        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(si,sj));
        boolean[][] flag = new boolean[h+2][w+2];
        flag[si][sj] = true;
        boolean[] letFlag = new boolean[30];
        int ans = -1;
        done:
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int l = node.l + dir[i][0];
                int r = node.r + dir[i][1];
                if (grid[l][r] != '#' && !flag[l][r]) {
                    flag[l][r] = true;
                    q.offer(new Node(l,r,node.n+1));
                    if (grid[l][r] == 'G') {
                        ans = node.n+1;
                        break done;
                    }
                }
            }

            if (grid[node.l][node.r] >= 'a' && grid[node.l][node.r] <= 'z') {
                int index = grid[node.l][node.r] - 'a';

                for (int i = 0; i < let[index].size() && !letFlag[index]; i++) {
                    int ll = let[index].get(i).l;
                    int rr = let[index].get(i).r;
                    if (ll == node.l && rr == node.r) {
                        continue;
                    }
                    if (!flag[ll][rr]) {
                        flag[ll][rr] = true;
                        q.offer(new Node(ll,rr,node.n+1));
                    }
                }
                letFlag[index] = true;
            }

        }

        out.println(ans);



    }
}
