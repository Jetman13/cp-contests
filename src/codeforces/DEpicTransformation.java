package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class DEpicTransformation {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            Map<Integer,Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int k = in.nextInt();
                int num = map.getOrDefault(k,0);
                map.put(k,num+1);
            }

            List<Integer> list = new ArrayList<>();
            map.forEach((k,v)->{
                list.add(v);
            });
            list.sort(Comparator.reverseOrder());

            int ans = 0;
            if (list.size() > 1) {
                if (list.get(0)*2 >= n) {
                    ans = n - (n - list.get(0))*2;
                }
            } else {
                ans = n;
            }
            if (ans == 0 && n%2==1) {
                ans = 1;
            }
            out.println(ans);

        }
    }
}
