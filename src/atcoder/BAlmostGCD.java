package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BAlmostGCD {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);

        int ans = -1;
        int ansNum = 0;
        for (int i = 2; i <= 1000 ; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] % i == 0) {
                    num++;
                }
            }
            if (ansNum < num) {
                ansNum = num;
                ans = i;
            }

        }
        out.println(ans);
    }
}
