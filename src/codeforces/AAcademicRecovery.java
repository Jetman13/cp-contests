package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AAcademicRecovery {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];

        Arrays.setAll(a,i->in.nextLong());

        Arrays.sort(a);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            out.print((a[i]-sum) + " ");
            sum = a[i];
        }
        out.println();

    }
}
