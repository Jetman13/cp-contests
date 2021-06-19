package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class DSnukePrime {
    class Node {
        int a,b;
        long c;

        public Node(int a, int b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long C = in.nextLong();
        Map<Integer,Long> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            Long l = map.getOrDefault(a,0L);
            l+=c;
            map.put(a,l);
            Long r = map.getOrDefault(b+1,0L);
            r-=c;
            map.put(b+1,r);
        }

        long ans = 0;
        int pre = 0;
        long val = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            long len = entry.getKey()-pre;
            ans += len*Math.min(val,C);
            val += entry.getValue();
            pre = entry.getKey();
        }
        out.println(ans);




    }
}
