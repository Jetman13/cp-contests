package atcoder;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CSwappable {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);

        RuffleSort.ruffleSort(a);

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = map.getOrDefault(a[i],0);
            num++;
            map.put(a[i],num);
        }

        long ans = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans += entry.getValue() * (long)(n-entry.getValue());
        }
        out.println(ans/2);

    }
}
