package atcoder;

import tool.FastReader;
import tool.RangeTree;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.Arrays;

public class DProjectPlanning {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n];
        in.readArr(a);
        RuffleSort.ruffleSort(a);

        long ans = 0;
        while (a[n-k] != 0) {
            ans += a[n-k];
            long tmp = a[n-k];
            for (int i = n-k; i < n; i++) {
                a[i]-=tmp;
            }
            a = merge(a,k);
        }
        out.println(ans);

    }

    private long[] merge(long[] a, int k) {
        long[] b = new long[a.length];
        int pi = 0;
        int pj = a.length-k;
        int p = 0;
        while (p<a.length) {
            if (pi >= a.length - k) {
                b[p++] = a[pj++];
            } else if (pj >= a.length) {
                b[p++] = a[pi++];
            } else {
                b[p++] = a[pi] > a[pj] ? a[pj++] : a[pi++];
            }
        }
        return b;
    }
}
