package nowcoder;

import tool.*;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class Task {



    long MOD = (long)1e9 + 9;
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long k = sc.nextLong();

            long w = n - m;
            long loop = n / k;

            if (w >= loop) {
                out.println(m);
            } else {
                long ans = w * (k - 1);
                long tmp = m - w * (k - 1);
                ans += tmp % k;
                long sum = k;
                long l = tmp / k;
                ans = (ans + sum * CommonUtils.binpow(2, l + 1, MOD)) % MOD;
                ans = (ans + MOD - sum * 2) % MOD;
                out.println(ans);
            }

        }




    }



}
