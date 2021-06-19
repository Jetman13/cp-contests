package codechef;

import tool.FastReader;
import tool.Primes;

import java.io.PrintWriter;

public class PrimeGame {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        Primes primes = new Primes(1000002);
        int[] sum = new int[1000004];
        for (int i = 1; i < primes.isPrime.length; i++) {
            sum[i] = sum[i-1] + (primes.isPrime[i] ? 1 : 0);
        }
        while (t-->0) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (sum[x] <= y) {
                out.println("Chef");
            } else {
                out.println("Divyam");
            }
        }
    }
}
