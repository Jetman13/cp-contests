package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class BPhoenixAndPuzzle {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i < 60; i++) {
            set.add((1L<<i));
        }

        for (long i = 2; i*i <= 1000000000L; i++) {
            set.add(i*i);
        }

        while (t-- > 0) {
            Long n = in.nextLong();

            if (n%2==1) {
                out.println("NO");
                continue;
            }

            n/=2;

            double tmp = Math.sqrt(n);
            int intTmp = (int)(tmp+0.00001);
            if (Math.abs(tmp-intTmp) < 0.00001) {
                out.println("YES");
                continue;
            }

            tmp/=Math.sqrt(2.0);
            intTmp = (int)(tmp+0.00001);
            if (Math.abs(tmp-intTmp) < 0.00001) {
                out.println("YES");
                continue;
            }


            out.println(set.contains(n) ? "YES":"NO");
        }
    }
}
