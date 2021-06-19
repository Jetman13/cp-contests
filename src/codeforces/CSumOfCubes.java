package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class CSumOfCubes {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        Set<Long> set = new HashSet<>();
        long max = (long)1e12;
        for (long i = 1; i < 10000; i++) {
                set.add(i*i*i);
        }
        while (t-->0) {
            long x = in.nextLong();
            boolean ans = false;
            for (long i = 1; i < 10000; i++) {
                if (set.contains(x - i*i*i)) {
                    ans = true;

                }
            }
            out.println(ans ? "YES":"NO");
        }
    }
}
