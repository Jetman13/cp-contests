package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DSameDifferences {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt() - i;
                Integer val = map.getOrDefault(a[i],0);
                val++;
                map.put(a[i],val);
            }

            long ans = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                long val = entry.getValue();
                ans += val*(val-1)/2;
            }
            out.println(ans);

        }
    }
}
