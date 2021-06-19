package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class CTeam {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            RuffleSort.ruffleSort(a);

            int ans = 0;

            int l = 0;
            int r = n-1;
            while (l <= r) {
                if (l == r) {
                    if (a[l] >= k) {
                        ans++;
                    }
                    break;
                }
                if (a[r] >= k) {
                    r--;
                    ans++;
                } else if (a[r] + a[l] >= k) {
                    r--;
                    l++;
                    ans++;
                } else {
                    l++;
                }
            }
            out.println(ans);
        }
    }
}
