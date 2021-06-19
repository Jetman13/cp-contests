package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FArrayPartition {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                b[i] = a[i];
            }
            Arrays.sort(b);
            int l = 0;
            int r = n-1;
            while (l<=r) {
                int mid = (l+r)/2;
                long tmp = a[mid];
                boolean flag = true;
//                for (int i = 0; i < ; i++) {
//
//                }
            }
            
        }
    }
}
