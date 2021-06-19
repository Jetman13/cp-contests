package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FEqualizeTheArray {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            Map<Integer,Integer> count = new HashMap();
            for (int i = 0; i < n; i++) {
                count.put(a[i],count.getOrDefault(a[i],0) + 1);
            }

            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                list.add(entry.getValue());
            }

            list.sort((aa,bb)->aa - bb);
            int ans = n;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0 || !list.get(i).equals(list.get(i-1))) {
                    ans = Math.min(ans,n-(list.size()-i)*list.get(i));
                }
            }
            out.println(ans);

        }
    }
}
