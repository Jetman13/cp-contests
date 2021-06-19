package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class DAddToNeighbourAndRemove {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            int ans = n-1;
            int sum = Arrays.stream(a).sum();
            for (int i = 2; i <= n ; i++) {
                if (sum%i != 0) continue;
                int tmp = sum/i;
                int index = 0;
                int s = 0;
                boolean f = true;
                while (index < n) {
                    s += a[index++];
                    if (s > tmp) {
                        f = false;
                        break;
                    } else if (s == tmp) {
                        s = 0;
                    }
                }
                if (f) {
                    ans = Math.min(ans,n-i);
                }
            }
            out.println(ans);
        }
    }
}
