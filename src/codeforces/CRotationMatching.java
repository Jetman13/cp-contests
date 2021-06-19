package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CRotationMatching {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        in.readArr(a);
        in.readArr(b);

        int[] indexa = new int[n+1];
        int[] indexb = new int[n+1];
        for (int i = 0; i < n; i++) {
            indexa[a[i]-1] = i;
        }
        for (int i = 0; i < n; i++) {
            indexb[b[i]-1] = i;
        }

        int[] num = new int[n+1];
        for (int i = 0; i < n; i++) {
            num[(indexa[i] + n - indexb[i])%n]++;
        }

        int max = Arrays.stream(num).max().getAsInt();
        out.println(max);

    }
}
