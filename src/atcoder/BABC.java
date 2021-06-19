package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BABC {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();

        a = a%10;
        long tmp = 1;
        List<Long> list = new ArrayList<>();

        while (true) {
            tmp = (tmp*a)%10;
            if (list.contains(tmp)) {
                break;
            }
            list.add(tmp);
        }

        long MOD = list.size();

        out.println(cal(a,binpow(b,c,MOD)));
    }

    private long cal(long a, long b) {
        a = a%10;
        long tmp = 1;
        List<Long> list = new ArrayList<>();

        while (true) {
            tmp = (tmp*a)%10;
            if (list.contains(tmp)) {
                break;
            }
            list.add(tmp);
        }
        b%=list.size();
        b = (b + list.size() - 1)%list.size();

        return list.get((int)b);


    }

    long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) > 0) res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }

}
