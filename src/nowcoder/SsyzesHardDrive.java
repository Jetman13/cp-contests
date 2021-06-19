package nowcoder;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class SsyzesHardDrive {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long s = in.nextInt();
        long[] a = new long[n];
        in.readArr(a);

        RuffleSort.ruffleSort(a);

        long ans = Long.MAX_VALUE;
        ans = Math.min(Math.abs(s - a[0]) + a[n-1] - a[0],ans);
        ans = Math.min(Math.abs(s - a[n-1]) + a[n-1] - a[0],ans);
        out.println(ans);

    }
}
