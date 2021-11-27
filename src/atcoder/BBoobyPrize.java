package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BBoobyPrize {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        in.readArr(a);
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (b[i] == a[n-2]) {
                out.println(i+1);
                break;
            }
        }
    }
}
