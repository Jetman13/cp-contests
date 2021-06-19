package codeforces;

import tool.FastReader;
import tool.FenwichTree;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class F1GuessTheKThZeroEasyVersion {
    FenwichTree ft;
    Map<Long,Integer> map;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int t = in.nextInt();
        ft = new FenwichTree(new int[n+1]);
        map = new HashMap<>();
        while (t-- > 0) {
            int k = in.nextInt();
            int l = 1;
            int r = n;
            int ans = 0;
            while (l <= r) {
                if (r == l) {
                    ans = l;
                    break;
                }
                if (r == l+1) {
                    int lnum = query(in,out,1,l);
                    if (l - lnum == k) {
                        ans = l;
                        break;
                    } else {
                        ans = r;
                        break;
                    }
                }
                int mid = (l+r)/2;
                int num = query(in,out,1,mid);
                int zero = mid - num;
                if (zero > k) {
                    r = mid - 1;
                } else if (zero < k){
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            ft.update(ans,1);
            out.println("! " + ans);
            out.flush();
        }
    }

    private int query(FastReader in, PrintWriter out, int l, int r) {
        Integer val = map.get(l*1000000L+r);
        if (val != null) {
            return val + ft.sumRange(l,r);
        }
        out.println("? "+l + " " + r);
        out.flush();
        val = in.nextInt();
        map.put(l*1000000L + r,val - ft.sumRange(l,r));
        return val;
    }
}
