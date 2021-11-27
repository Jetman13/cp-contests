package atcoder;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class CMinDifference {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        in.readArr(a);
        in.readArr(b);

        RuffleSort.ruffleSort(a);
        RuffleSort.ruffleSort(b);

        int p = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int min = Math.abs(b[p] - a[i]);
            int k = p;
            while (k < m && Math.abs(b[k]-a[i]) <= min) {
                min = Math.abs(b[k]-a[i]);
                p = k;
                k++;
            }
            ans = Math.min(ans,min);

        }
        out.println(ans);

    }
}
