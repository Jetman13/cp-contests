package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class C1GuessingTheGreatestEasyVersion {
    Map<String,Integer> map;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        map = new HashMap<>();
        int n = in.nextInt();
        int sed = query(1,n,in,out);
        out.println("! " + cal(1,n,sed,in,out));
        out.flush();
    }

    private int cal(int l, int r,int sed, FastReader in, PrintWriter out) {
        if (l == r) {
            return l;
        }
        //int p = query(l,r,in,out);

        //if (l+1 == r) return p == l ? r : l;

        int mid = (l+r)/2;
         if (sed <= mid) {
            if (Math.min(sed,l) == mid) {
                return cal(mid+1,r,sed,in,out);
            }
            int lp = query(Math.min(sed,l),mid,in,out);
            if (lp == sed) {
                return cal(l,mid,sed,in,out);
            } else {
                return cal(mid+1,r,sed,in,out);
            }
        } else {
             if (mid+1 == Math.max(r,sed)) {
                 return cal(l,mid,sed,in,out);
             }
            int rp = query(mid+1,Math.max(r,sed),in,out);
            if (rp == sed) {
                return cal(mid+1,r,sed,in,out);
            } else {
                return cal(l,mid,sed,in,out);
            }
        }
    }

    private int query(int l, int r, FastReader in, PrintWriter out) {
        Integer num = map.get(l+"#"+r);
        if (num != null) return num;

        out.println("? " + l + " " + r);
        out.flush();
        num = in.nextInt();
        map.put(l+"#"+r,num);
        return num;
    }
}
