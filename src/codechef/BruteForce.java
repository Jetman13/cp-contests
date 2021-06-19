package codechef;

import tool.FastInput;
import tool.FastReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class BruteForce {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            int[] num = new int[40];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                num[getMaxBit(a[i])]++;
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int bit = getMaxBit(a[i]);
                for (int j = bit-1; j > 0; j--) {
                    if ((a[i]&(1<<(j-1))) <= 0) {
                        ans+=num[j];
                    }
                }
            }
//            out.println("*******" + (ans == check(a)));
            out.println(ans);
        }
        out.flush();
    }

    private int check(long[] a) {
        int n = a.length;
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if ((a[i]^a[j]) > Math.max(a[i],a[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int getMaxBit(long l) {
        int k = 0;
        while (l != 0) {
            l/=2;
            k++;
        }
        return k;
    }
}
