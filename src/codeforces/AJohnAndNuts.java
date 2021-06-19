package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AJohnAndNuts {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);
        int k = in.nextInt();
        int sum = Arrays.stream(a).sum();
        for (int i = 0; i < k; i++) {
            int tmp = in.nextInt();
            sum -= a[tmp-1];
        }
        out.println(sum+1);
    }
}
