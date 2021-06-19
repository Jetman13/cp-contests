package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CORXOR {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        in.readArr(a);
        long ans = Long.MAX_VALUE;
        int[] bit = new int[n];
        for (int i = 0; i < (1<<n); i++) {
            for (int j = 0; j < n; j++) {
                bit[j] = (i&(1<<j)) > 0 ? 1 : 0;
            }
            ans = Math.min(ans,cal(bit,a));
        }
        out.println(ans);
    }

    private long cal(int[] bit, long[] a) {
        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            int p = i+1;
            long tmp = a[i];
            while (p < a.length && bit[p] == bit[i]) {
                tmp|=a[p];
                p++;
            }
            i = p-1;
            ans^=tmp;
        }
        return ans;
    }
}
