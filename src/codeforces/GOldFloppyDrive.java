package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class GOldFloppyDrive {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int m = in.nextInt();
            long[] a = new long[n];
            in.readArr(a);

            long[] sum = new long[n+1];
            for (int i = 0; i < n; i++) {
                sum[i+1] = sum[i] + a[i];
            }

            List<Long> list = new ArrayList<>();
            List<Integer> indexList = new ArrayList<>();
            long max = 0;
            for (int i = 1; i <= n; i++) {
                if (sum[i] > max) {
                    list.add(sum[i]);
                    indexList.add(i);
                    max = sum[i];
                }
            }

            for (int i = 0; i < m; i++) {
                long x = in.nextLong();
                long ans = 0;
                if (x > max) {
                    if (sum[n] <= 0) {
                        out.println(-1);
                        continue;
                    }
                    ans += n*(long)Math.ceil((x - max)/(1.0*sum[n]));
                    x -= (long)Math.ceil((x - max)/(1.0*sum[n]))*sum[n];
                }
                int p = Collections.binarySearch(list,x);
                if (p >= 0) {
                    ans += indexList.get(p);
                } else {
                    ans += indexList.get(-p -1);
                }
                out.println(ans-1);
            }


        }
    }
}
