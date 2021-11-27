package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DTakahashiTour {
    List<Integer>[] edge;
    List<Integer> ans;
    int[] index;
    boolean end;
    boolean[] vis;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        edge = new ArrayList[n+1];
        index = new int[n+1];
        Arrays.setAll(edge,i->new ArrayList<>());

        for (int i = 1; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            edge[l].add(r);
            edge[r].add(l);
        }
        for (int i = 1; i <= n; i++) {
            edge[i].sort(Comparator.naturalOrder());
        }
        ans = new ArrayList<>();
        end = false;
        vis = new boolean[n+1];
        dfs(1,-1);
        for (int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i) + " ");
        }
        out.println();

    }

    private void dfs(int node, int fa) {
        if (!end) ans.add(node);
        vis[node] = true;
        int start = index[node];
        List<Integer> next = edge[node];
        if (node == 1 && start >= next.size()) {
            end = true;
            return ;
        }
        for (int i = start; i < next.size(); i++) {
            if (vis[next.get(i)]) continue;
            index[node] = i+1;
            dfs(next.get(i),node);
            if(!end) ans.add(node);
        }
    }
}
