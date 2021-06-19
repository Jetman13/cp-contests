package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class CCA {
    class Node {
        int l;
        int r;
        long val;

        public Node(int l, int r, long val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
    int[] fa;
    int fa(int root) {
        return fa[root] == root ? root : (fa[root] = fa(fa[root]));
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int mm = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        if (n <= 1 || mm <= 0 || s == t) {
            out.println("0 0");
            return ;
        }

        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= mm; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            long val = in.nextLong();
            list.add(new Node(l,r,val));
        }
        Collections.sort(list,(a,b)->{
            if (a.val == b.val) return 0;
            else if (a.val > b.val) return 1;
            return -1;
        });

        int l = 0;
        int r = mm-1;
        long ansl = list.get(l).val;
        long ansr = list.get(r).val;
        fa = new int[n+3];
        while (l <= r) {
            int mid = (l+r)/2;
            Arrays.setAll(fa,i->i);
            boolean flag = false;
            for (int i = mid; i < mm; i++) {
                Node node = list.get(i);
                int lf = fa(node.l);
                int rf = fa(node.r);
                if (lf != rf) {
                    fa[lf] = rf;
                }
                if (fa(s) == fa(t)) {
                    ansl = list.get(mid).val;
                    ansr = node.val;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        out.printf(ansl + " " + ansr);

    }


}
