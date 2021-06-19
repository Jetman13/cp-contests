package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BManyOranges {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextLong();
        long b = in.nextLong();
        long w = in.nextLong()*1000;

        long l = w/b-1;
        long r = w/a+1;

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (long i = l; i <= r ; i++) {
            double tmp = w/(i*1.0);
            if ((tmp >= a && tmp <= b)) {
                min = Math.min(min,i);
                max = Math.max(max,i);
            }
        }
        if (min == Long.MAX_VALUE) {
            out.println("UNSATISFIABLE");
        } else {
            out.println(min + " " + max);
        }

    }
}
