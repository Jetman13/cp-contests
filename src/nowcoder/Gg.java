package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Gg {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        Arrays.setAll(a,i->in.nextLong());

        int index = 0;
        long tmp = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < tmp) {
                index = i+1;
                tmp = a[i];
            }
        }
        out.println(index);
        
    }
}
