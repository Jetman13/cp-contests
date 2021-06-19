package tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 质数工具类
 * @author: Jetman
 * @create: 2020-11-06 21:16
 **/
public class Primes {

    public boolean[] isPrime;
    public List<Integer> primeList;
    public int n;

    public Primes(int n) {
        this.n = n;
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        primes(n);
    }

    public List<Integer> count() {
        if (primeList != null) {
            return primeList;
        }
        primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {  //记录质数
                primeList.add(i);
            }
        }
        return primeList;
    }

    private void primes(int n) {
        isPrime[1] = false;
        isPrime[0] = false;
        for (int i = 2; i <= n; i++) {
            //如果当前数为质数
            if (isPrime[i]) {
                //将对应数的倍数变为0
                for (int j = 2; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }


}
