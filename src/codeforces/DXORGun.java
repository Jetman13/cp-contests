package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DXORGun {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        if (check(a)) {
            out.println(1);
            return ;
        }

        int ans = -1;
        done:
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= n-i; j++) {
                long tmp = 0;
                for (int k = j; k < j+i-1; k++) {
                    long l = 0;
                    for (int m = j; m <= k; m++) {
                        l^=a[m];
                    }
                    long r = 0;
                    for (int m = k+1; m < j+i; m++) {
                        r^=a[m];
                    }
                    if (l > r) {
                        ans = i-2;
                        break done;
                    }
                }
            }
        }
        out.println(ans);

    }

    private boolean check(long[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            long tmp = a[i]^a[i-1];
            if (i>1 && tmp < a[i-2]) {
                return true;
            }
            if (i < len-1 && tmp > a[i+1]) {
                return true;
            }
        }
        return false;
    }
}
