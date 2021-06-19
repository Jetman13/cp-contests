package tool;

/**
 * @description:
 * @author: Jetman
 * @create: 2021-02-21 22:47
 **/
public class CommonUtils {

    public static long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) > 0) res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
