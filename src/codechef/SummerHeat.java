package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class SummerHeat {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long[] a = new long[4];
            in.readArr(a);

            out.println(Math.floorDiv(a[2],a[0]) + Math.floorDiv(a[3],a[1]));
        }
    }
}
