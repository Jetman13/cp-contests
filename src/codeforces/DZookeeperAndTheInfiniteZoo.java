package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DZookeeperAndTheInfiniteZoo {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        List<Long> pow = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            pow.add(1L<<i);
        }
        while (t-- > 0) {
            long u = in.nextLong();
            long v = in.nextLong();
            if (u == v) {
                out.println("YES");
                continue;
            }
            if (u > v) {
                out.println("NO");
                continue;
            }

            List<Integer> la = new ArrayList<>();
            List<Integer> lb = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                if (((1<<i)&u) > 0) {
                    la.add(i);
                }
                if (((1<<i)&v) > 0) {
                    lb.add(i);
                }
            }

            if (la.size() < lb.size()) {
                out.println("NO");
                continue;
            }
            
            boolean ans = true;
            for (int i = 0; i < Math.min(la.size(),lb.size()); i++) {
                if (la.get(i) > lb.get(i)) {
                    ans = false;
                    break;
                }
            }

            out.println(ans ? "YES":"NO");

        }
    }
}
