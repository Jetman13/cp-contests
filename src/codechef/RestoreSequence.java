package codechef;

import tool.FastReader;
import tool.Primes;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class RestoreSequence {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        Primes primesTool = new Primes(4*1000000);
        List<Integer> primes = primesTool.count();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] b = new int[n];
            int[] a = new int[n];
            in.readArr(b);
            Arrays.fill(a,-1);
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (a[b[i]-1] != -1) {
                    a[i] = a[b[i]-1];
                } else {
                    a[i] = primes.get(index);
                    a[b[i]-1] = primes.get(index);
                    index++;
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(a[i]+" ");
            }
            out.println();
        }
    }
}
