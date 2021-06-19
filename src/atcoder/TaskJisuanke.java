package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskJisuanke {

    class Node{
        String name;
        long v;

        public Node(String name, long v) {
            this.name = name;
            this.v = v;
        }
    }
    long MOD = 998244353L;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        getFac(2000001);

        //long ans = 0;

        out.println(C(m+n-1,m));
    }

    long[] fac = new long[2000002];

    long quickPow(long n,long m){
        long ans = 1;
        n %= MOD;
        while(m > 0){
            if((m & 1) > 0)
                ans = ans * n % MOD;
            n = n * n % MOD;
            m >>= 1;
        }
        return ans;
    }
    void getFac(int n){
        fac[0]=fac[1]=1;
        for(int i=2;i<=n;++i){
            fac[i]=fac[i-1] * i % MOD;
        }
    }

    long C(long n,long m){
        if(m>n)
            return 0;
        return fac[(int)n]*quickPow(fac[(int)m]*fac[(int)(n-m)],MOD-2) % MOD;
    }

    long Lucas(long n,long m){
        if(m == 0)
            return 1;
        return C(n%MOD,m%MOD)*Lucas(n/MOD,m/MOD) % MOD;
    }

}
