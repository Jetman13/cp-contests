package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CBinarySearch {

    long MOD = (long)1e9 + 7;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int pos = in.nextInt();

        int less = 0;
        int more = 0;
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r)/2;
            if (mid <= pos) {
                if (mid != pos) less++;
                l = mid + 1;
            } else {
                r = mid;
                more++;
            }
        }
        if (less >= x || more > (n-x)) {
            out.println("0");
            return ;
        }
        long ans = A(x-1,less);
        ans = (ans*A(n-x,more))%MOD;
        ans = (ans*A(n-less-more-1,n-less-more-1))%MOD;
        out.println(ans);

    }

    private long A(int a, int b) {
        long ans = 1;
        for (int i = 0; i < b; i++) {
            ans = (ans*(a-i))%MOD;
        }
        return ans;
    }
}
