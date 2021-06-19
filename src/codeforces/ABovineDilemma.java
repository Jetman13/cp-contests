package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class ABovineDilemma {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int  t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            Arrays.sort(a);
            int[] f = new int[100];
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    f[a[j]-a[i]] = 1;
                }
            }
            out.println(Arrays.stream(f).sum());
        }
    }
}
