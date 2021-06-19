package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class BSifidAndStrangeSubsequences {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            in.readArr(a);

            int num = 0;
            long k = 0;
            int index = -1;
            RuffleSort.ruffleSort(a);
            for (int i = 0; i < n; i++) {
                if (a[i] <= 0) {
                    num++;
                } else {
                    k = a[i];
                    index = i;
                    break;
                }
            }

            if (k > 0) {
                int ans = 1;
                long pre = k;
                for (int i = index-1; i >= 0 ; i--) {
                    if (Math.abs(a[i] - pre) >= k) {
                        ans++;
                        pre = a[i];
                    }
                }
                num = Math.max(ans,num);
            }



            out.println(num);

        }
    }
}
