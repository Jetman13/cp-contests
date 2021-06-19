package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class B2BiodiverseSubarray {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();


        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        long ans = 0;
        int[] flag = new int[k+1];
        int len = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < n; i++) {
            while (r < n && len < k) {
                if (flag[num[r]] == 0) len++;
                flag[num[r++]]++;
            }

            if (len == k) ans += n-r+1;

            if (flag[num[i]] == 1) len--;
            flag[num[i]]--;
        }
        out.println(ans);


    }
}
