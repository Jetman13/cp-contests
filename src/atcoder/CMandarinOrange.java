package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CMandarinOrange {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        int[] a = new int[n+2];
        a[0] = a[n+1] = -1;
        for (int i = 1; i <= n ; i++) {
            a[i] = in.nextInt();
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int l = i;
            while (a[l] >= a[i]) l--;
            int r = i;
            while (a[r] >= a[i]) r++;
            ans = Math.max(ans,(r-l-1)*a[i]);
        }
        out.println(ans);

    }
}
