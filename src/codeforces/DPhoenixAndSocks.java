package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DPhoenixAndSocks {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            Map<Integer,Integer> lmap = new HashMap<>();
            Map<Integer,Integer> rmap = new HashMap<>();
            for (int i = 0; i < l; i++) {
                int k = in.nextInt();
                int num = lmap.getOrDefault(k,0);
                num++;
                lmap.put(k,num);
            }
            for (int i = l; i < n; i++) {
                int k = in.nextInt();
                int num = rmap.getOrDefault(k,0);
                num++;
                rmap.put(k,num);
            }

            Map<Integer,Integer> clone = new HashMap<>(lmap);
            for (Map.Entry<Integer, Integer> entry : clone.entrySet()) {
                Integer k = entry.getKey();
                Integer num = rmap.get(k);
                if (num !=null) {
                    int lnum = lmap.get(k);
                    int rnum = rmap.get(k);
                    int min = Math.min(lnum,rnum);
                    l-=min;
                    r-=min;
                    if (lnum > min)
                    lmap.put(k,lnum - Math.min(lnum,rnum));
                    else
                        lmap.remove(k);
                    if (rnum > min)
                    rmap.put(k,rnum - Math.min(lnum,rnum));
                    else
                        rmap.remove(k);
                }
            }

            if (l < r) {
                Map tmp = lmap;
                lmap = rmap;
                rmap = tmp;
                int tmpint = l;
                l = r;
                r = tmpint;
            }



            int ans = 0;
            int removeNum = l - r;

            clone = new HashMap<>(lmap);
            for (Map.Entry<Integer, Integer> entry : clone.entrySet()) {
                if (entry.getValue() > 1) {

                    int tmp = Math.min((entry.getValue()/2)*2,removeNum);

                    ans += tmp/2;
                    removeNum -= tmp;
                    l-=tmp;
                    if (entry.getValue() - tmp == 0) {
                        lmap.remove(entry.getKey());
                    } else {
                        lmap.put(entry.getKey(), entry.getValue()-tmp);
                    }
                }
            }
            ans += Math.max(l,r);

//            ans = removeKey(lmap);
//
//            ans += removeKey(rmap);
//
//            ans += lmap.size() + rmap.size();
            out.println(ans);

        }
    }

    private int removeKey(Map<Integer, Integer> lmap) {
        int ans = 0;
        Map<Integer, Integer> clone;
        clone = new HashMap<>(lmap);
        for (Map.Entry<Integer, Integer> entry : clone.entrySet()) {
            if (entry.getValue() > 1) {
                ans += entry.getValue() / 2;
                if (entry.getValue() % 2 == 0) {
                    lmap.remove(entry.getKey());
                } else {
                    lmap.put(entry.getKey(), 1);
                }
            }
        }
        return ans;
    }
}
