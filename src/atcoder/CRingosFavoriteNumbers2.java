package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CRingosFavoriteNumbers2 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);

        int[] mod = new int[201];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int m = a[i]%200;
            ans += mod[m];
            mod[m]++;
        }
        out.println(ans);
    }
}
