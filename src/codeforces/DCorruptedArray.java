package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.Arrays;

public class DCorruptedArray {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] b = new long[n+2];
            in.readArr(b);
            RuffleSort.ruffleSort(b);

            long sum = Arrays.stream(b).sum();

            boolean f = false;
            for (int i = 0; i < n+2; i++) {
                long max = i == n+1 ? b[i-1] : b[n+1];
                int p = i == n+1 ? i-1 : n+1;
                if (max == sum - max - b[i]) {
                    for (int j = 0; j < n+2; j++) {
                        if (j == p || j == i) continue;
                        out.print(b[j] + " ");
                    }
                    out.println();
                    f = true;
                    break;
                }
            }

            if (!f) {
                out.println(-1);
            }

        }
    }
}
