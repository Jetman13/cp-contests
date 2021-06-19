package atcoder;

import tool.FastReader;
import tool.Permutation;

import java.io.PrintWriter;

public class CTravel {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long[][] dis = new long[10][10];
        int n = in.nextInt();
        long w = in.nextLong();
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n; j++) {
                dis[i][j] = in.nextLong();
            }
        }

        Permutation pm = new Permutation();
        int[] a = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            a[i] = i+2;
        }

        long ans = 0;
        do {
            int pre = 1;
            long tmp = 0;
            for (int i = 0; i < a.length; i++) {
                tmp += dis[pre][a[i]];
                pre = a[i];
            }
            tmp += dis[pre][1];
            if (tmp == w) {
                ans++;
            }

        } while (pm.next(a));
        out.println(ans);

    }
}
