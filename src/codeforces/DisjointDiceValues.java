package codeforces;

public class DisjointDiceValues {
    public double getProbability(int A, int B) {
        if (A == 0 || B == 0) return 0D;
        
        int mask = (1<<6);
        double[] dpa = new double[mask+1];
        double[] dpb = new double[mask+1];
        long[] Arr = new long[20];
        Arr[0] = 1;
        double[] pow = new double[20];
        pow[0] = 1;
        for (int i = 1; i < 20; i++) {
            pow[i] = pow[i-1]*(1.0/6.0);
        }
        for (int i = 1; i < 20; i++) {
            Arr[i] = Arr[i-1]*i;
        }

//        for (int i = 1; i < mask; i++) {
//            int num = calNum(i);
//            if (num <= A) {
//                double tmp = 1;
//                for (int j = 0; j < A-num; j++) {
//                    tmp *= (num / 6.0);
//                }
//                dpa[i] = tmp*Arr[num]*pow[num];
//            }
//
//            if (num <= B) {
//                double tmp = 1;
//                for (int j = 0; j < B-num; j++) {
//                    tmp *= (num / 6.0);
//                }
//                dpb[i] = tmp*Arr[num]*pow[num];
//            }
//        }

        double[][] dp = new double[A+B+1][(1<<6)+2];
        dp[0][0] = 1;
        for (int i = 1; i <= A+B; i++) {
            for (int j = 1; j < (1<<6); j++) {
                int num = calNum(j);
                if (num > i) continue;
                dp[i][j] = dp[i-1][j]*(num/6.0);
                for (int k = 0; k < 6; k++) {
                    if (((1<<k)&j) > 0) {
                        dp[i][j] += dp[i-1][j^(1<<k)]*(1.0/6.0);
                    }
                }
            }
        }

        double ans = 0;
        for (int i = 1; i < mask; i++) {
            for (int j = 1; j < mask; j++) {
                int in = calNum(i);
                int jn = calNum(j);
                if ((i&j) > 0 && in <= A && jn <= B) {
//                    ans += dpa[i]*dpb[j];
                    ans += dp[A][i]*dp[B][j];
                }
            }
        }

        
        return ans;
    }


    private double com(int a, int b) {
        if (a == 0) return 1;
        long num = 1;
        for (int i = 0; i < b; i++) {
            num *= (a-i);
        }
        for (int i = 0; i < b; i++) {
            num /= (i+1);
        }
        return num;
    }

    private int calNum(int i) {
        int num = 0;
        while (i>0) {
            num+=(i%2==1) ? 1 : 0;
            i/=2;
        }
        return num;
    }
}
