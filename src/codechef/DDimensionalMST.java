package codechef;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DDimensionalMST {

    class Node {
        int u;
        int v;
        int w;
        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        int d = in.nextInt();
        int[][] point = new int[n][d];
        for (int i = 0; i < n; i++) {
            in.readArr(point[i]);
        }
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < (1<<d); i++) {
            int max = Integer.MIN_VALUE;
            int p = 0;
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                for (int k = 0; k < d; k++) {
                    tmp += (((1<<k)&i) > 0 ? 1:-1) * point[j][k];
                }
                if (max < tmp) {
                    max = tmp;
                    p = j;
                }
            }

            for (int j = 0; j < n; j++) {
                if (j == p) continue;
                nodeList.add(new Node(j,p,dis(point,j,p)));
            }
        }

        nodeList.sort((a,b) -> b.w - a.w);

        fa = new int[n+1];
        Arrays.setAll(fa,i->i);

        long ans = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            int l = fa(nodeList.get(i).u);
            int r = fa(nodeList.get(i).v);
            if (l != r) {
                ans += nodeList.get(i).w;
                fa[l] = r;
            }
        }
        out.println(ans);


    }

    int[] fa;
    int fa(int k) {
        return fa[k] == k ? k : (fa[k] = fa(fa[k]));
    }

    private int dis(int[][] point, int j, int p) {
        int sum = 0;
        for (int i = 0; i < point[0].length; i++) {
            sum += Math.abs(point[j][i] - point[p][i]);
        }
        return sum;
    }
}
