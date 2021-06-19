package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class KKallipolis {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];

        Arrays.setAll(a,i->in.nextLong());

        long max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i+1;
            }
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (max%a[i]!=0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            out.println(index);
        } else {
            out.println("-1");
        }

    }
}
