package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ASpyDetected {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t--> 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(a[i],map.getOrDefault(a[i],0)+1);
            }

            final int[] val = {0};
            map.forEach((k,v) -> {
                if (v == 1) {
                    val[0] = k.intValue();
                }
            });

            int p = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == val[0]) {
                    p = i+1;
                    break;
                }
            }
            out.println(p);

        }
    }
}
