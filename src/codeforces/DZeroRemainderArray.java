package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DZeroRemainderArray {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();
            long max = -1;
            Map<Long,Long> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long tmp = in.nextLong()%k;
                if (tmp == 0) continue;
                long val = map.getOrDefault(tmp,-1L);
                if (val == -1) {
                    val = k-tmp;
                } else {
                    val+=k;
                }
                max = Math.max(max,val);
                map.put(tmp,val);
            }
            out.println(max+1);
        }
    }
}
