package codechef;

import tool.FastReader;
import tool.Pair;

import java.io.PrintWriter;

public class CollegeLife4 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            long n = in.nextLong();
            long e = in.nextLong();
            long h = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();


            long ans = Long.MAX_VALUE;
            for (int i = 0; i <= Math.min(e,h) && i <= n; i++) {
                Pair<Long,Long> ab = cal(a,b,e-i,h-i,n-i);
                if (ab != null) {
                    ans = Math.min(ans,ab.getKey()*a+ab.getValue()*b+i*c);
                }
            }
            out.println(ans == Long.MAX_VALUE ? -1 : ans);
        }
    }

    private Pair<Long, Long> cal(long a, long b, long e, long h, long n) {
        long aa = 0;
        long bb = 0;
        if (a < b) {
            aa = e/2 >= n ? n : e/2;
            bb = h/3 >= (n-aa) ? (n-aa) : h/3;
        } else {
            bb = h/3 >= n ? n : h/3;
            aa = e/2 >= (n-bb) ? (n-bb) : e/2;
        }
        if (aa + bb < n) {
            return null;
        }
        return new Pair<>(aa,bb);
    }
}
