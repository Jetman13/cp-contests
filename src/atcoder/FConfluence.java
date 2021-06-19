package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class FConfluence {
    int[] fa;
    int fa(int k) {
        return fa[k] == k ? k : (fa[k] = fa(fa[k]));
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        int q = in.nextInt();
        Map<Integer,Integer>[] map = new HashMap[n+1];
        for (int i = 0; i < n; i++) {
            int clas = in.nextInt()-1;
            if (map[i] == null) map[i] = new HashMap<>();
            map[i].put(clas,1);
        }

        fa = new int[n+1];
        Arrays.setAll(fa,i->i);

        for (int i = 0; i < q; i++) {
            int op = in.nextInt();
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            if (op == 1) {
                int lf = fa(l);
                int rf = fa(r);
                if (lf == rf) continue;
//                if (map[lf].size() < map[rf].size()) {
//                    int tmp = lf;
//                    lf = rf;
//                    rf = tmp;
//                }
                int finalLf = lf;
                map[rf].forEach( (a, b) -> {
                    int num = map[finalLf].getOrDefault(a,0);
                    map[finalLf].put(a,num+b);
                });
                map[rf].clear();
                fa[rf] = lf;
            } else {
                int f = fa(l);
                if (map[f] == null) {
                    out.println(0);
                } else {
                    out.println(map[f].getOrDefault(r, 0));
                }
            }
        }




    }
}
