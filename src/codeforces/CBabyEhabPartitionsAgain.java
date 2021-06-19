package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CBabyEhabPartitionsAgain {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        int p = -1;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
            if (a[i]%2==1) {
                p = i;
            }
        }
        if (sum%2==1 || !check(Arrays.stream(a).toArray(),sum)) {
            out.println(0);
            return;
        }

        if (p != -1) {
            out.println(1);
            out.println(p+1);
            return ;
        }

        for (int i = 0; i < a.length; i++) {
            int[] tmp = new int[n-1];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (j!=i) {
                    tmp[index++] = a[j];
                }
            }
            if (!check(tmp,sum-a[i])) {
                out.println(1);
                out.println(i+1);
                return ;
            }
        }
        out.println(-1);

    }

    private boolean check(int[] a, int sum) {
        if (sum%2==1) return false;


        int mid = sum/2;
        boolean[] dp = new boolean[mid+1];
        //dp[a[0]] = true;
        dp[0] = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = mid; j >= a[i] ; j--) {
                if (!dp[j] && dp[j-a[i]]) {
                    dp[j] = true;
                }
            }
        }
        return dp[mid];


    }
}
