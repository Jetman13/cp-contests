package codechef;

import tool.FastReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximiseFunction {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            in.readArr(a);
            Arrays.sort(a);
            out.println(2*(a[n-1] - a[0]));
        }
    }
}
