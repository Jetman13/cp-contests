package codeforces;

import tool.FastReader;
import tool.Primes;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GStrangeBeauty {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        Primes primes = new Primes(200001);
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            Arrays.sort(a);

            int[] nums = new int[200002];
            List<Integer> list = new ArrayList<Integer>();
            list.add(a[0]);
            nums[a[0]]++;
            for (int i = 1; i < n; i++) {
                if (a[i] != a[i-1]) {
                    list.add(a[i]);
                }
                nums[a[i]]++;
            }



            int size = list.size();

            for (int i = 1; i < size; i++) {
                int tmp = list.get(i);
                int max = nums[tmp] + nums[1];
                for (int j = 2; j*j <= tmp && !primes.isPrime[tmp]; j++) {
                    if (tmp % j != 0) continue;
                    max = Math.max(max,nums[tmp/j]+nums[tmp]);
                    max = Math.max(max,nums[j]+nums[tmp]);
                }
                nums[tmp] = max;
            }

            out.println(n - Arrays.stream(nums).max().getAsInt());


        }
    }
}
