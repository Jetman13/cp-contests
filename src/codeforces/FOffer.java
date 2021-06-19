package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FOffer {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- >0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n+1];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            a[n] = 1000002;

            int ans = 0;
            int[] num = new int[1000003];
            int r = -1;
            int sum = 0;
            for (int i = 0; i < n; i++) {

                while (sum <= k && r < n) {
                    r++;
                    if (num[a[r]] == 0) {
                        sum+=a[r];
                        num[a[r]]++;
                    } else {
                        num[a[r]]++;
                    }
                }
                ans = Math.max(ans,r-i);
                if (num[a[i]] == 1) {
                    num[a[i]]--;
                    sum-=a[i];
                } else {
                    num[a[i]]--;
                }
            }
            out.println(ans);
        }
    }
}
