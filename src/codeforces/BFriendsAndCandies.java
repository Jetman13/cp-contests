package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.Arrays;

public class BFriendsAndCandies {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            in.readArr(a);

            long sum = Arrays.stream(a).sum();

            if (sum%n != 0) {
                out.println(-1);
                continue;
            }

            long mid = sum/n;
            RuffleSort.ruffleSort(a);

            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] > mid) ans++;
            }
            out.println(ans);

        }
    }
}
