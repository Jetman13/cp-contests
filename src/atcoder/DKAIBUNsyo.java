package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class DKAIBUNsyo {
    int[] fa;
    int fa(int root) {
        return fa[root] == root ? root : (fa[root] = fa(fa[root]));
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);

        Set<Integer> set = new HashSet<>();
        fa = new int[200002];
        Arrays.setAll(fa,i->i);
        for (int i = 0; i < n/2; i++) {
            if (a[i] != a[n-i-1]) {
                int l = fa(a[i]);
                int r = fa(a[n-i-1]);
                if (l != r) {
                    fa[l] = fa[r];
                }
            }
        }

        boolean[] flag = new boolean[200002];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n/2; i++) {
            if (a[i] != a[n-1-i]) {
                int root = fa(a[i]);
                int num = map.getOrDefault(root,0);
                if (!flag[a[i]]) {
                    num++;
                    flag[a[i]] = true;
                }
                if (!flag[a[n-i-1]]) {
                    num++;
                    flag[a[n-i-1]] = true;
                }
                map.put(root,num);
            }
        }

        long ans = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans += entry.getValue()-1;
        }

        out.println(ans);
    }
}
