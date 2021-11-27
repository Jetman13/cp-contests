package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class EGraphDestruction {
    int[] fa;
    int fa(int root) {
        return fa[root] == root ? fa[root] : (fa[root] = fa(fa[root]));
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer>[] edges = new ArrayList[n+1];
        Arrays.setAll(edges,i->new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            edges[l].add(r);
            edges[r].add(l);
        }

        fa = new int[n+1];
        Arrays.setAll(fa,i->i);
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        ans.add(0);
        ans.add(1);
        set.add(n);
        int pre = 1;
        for (int i = n-1; i > 1 ; i--) {
            Set<Integer> pset = new HashSet<>();
            for (Integer ne : edges[i]) {
                if (set.contains(ne)) {
                    int neFa = fa(ne);
                    pset.add(neFa);
                }
            }
            set.add(i);
            for (Integer son : pset) {
                fa[son] = i;
            }
            pre = pre - pset.size() + 1;
            ans.add(pre);
        }

        for (int i = n-1; i >= 0 ; i--) {
            out.println(ans.get(i));
        }

    }
}
