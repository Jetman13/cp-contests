package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DSequenceAndSwaps {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            if (check(a)) {
                out.println(0);
                continue;
            }
            int[] dp = new int[n+3];
            int[] pre = new int[n+3];
            int ans = 1;
            int index = 0;
            dp[0] = 1;
            Arrays.fill(pre,-1);
            for (int i=1;i<n;i++) {
                dp[i] = 1;
                int max = -100;
                for (int j=0;j<i;j++) {
                    if (a[i] > a[j] && dp[j] > max) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                        max = dp[j];
                    }
                }
                if (ans < dp[i]) {
                    ans = dp[i];
                    index = i;
                }
            }

            List<Integer> list = new ArrayList<>();
            list.add(index);
            while (pre[index] != -1) {
                index = pre[index];
                list.add(index);
            }

            for (int i = list.size()-1; i >=0 ; i--) {
                int k = list.get(i);
                int tmp = x;
                x = a[k];
                a[k] = tmp;
            }

            out.println(check(a) ? list.size() : -1);

        }
    }

    private boolean check(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i-1]) {
                return false;
            }
        }
        return true;
    }
}
