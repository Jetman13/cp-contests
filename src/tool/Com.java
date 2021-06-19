package tool;

/**
 * @description: 组合
 * @author: Jetman
 * @create: 2020-11-01 12:21
 **/
public class Com {

    long p;
    public Com(long p) {
        this.p = p;
    }

    long quick_mod(long a, long b)
    {
        long ans = 1;
        a %= p;
        while(b > 0)
        {
            if((b & 1) > 0)
            {
                ans = ans * a % p;
                b--;
            }
            b >>= 1;
            a = a * a % p;
        }
        return ans;
    }

    public long C(long n, long m)
    {
        if(m > n) return 0;
        long ans = 1;
        for(int i=1; i<=m; i++)
        {
            long a = (n + i - m) % p;
            long b = i % p;
            ans = ans * (a * quick_mod(b, p-2) % p) % p;
        }
        return ans;
    }

    long Lucas(long n, long m)
    {
        if(m == 0) return 1;
        return C(n % p, m % p) * Lucas(n / p, m / p) % p;
    }

}
