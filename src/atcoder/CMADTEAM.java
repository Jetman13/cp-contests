package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class CMADTEAM {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[][] a = new int[n][5];
        in.readArr(a);

        int ans = 0;
        int l = 1;
        int r = (int)1e9;
        while (l <= r) {
            int mid = (l+r)/2;
            if (check(a,mid)) {
                ans = Math.max(ans,mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        out.println(ans);
    }

    private boolean check(int[][] a, int mid) {
        Set<Integer> set = new HashSet<>();
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                int bit = a[i][j] >= mid ? 1 : 0;
                tmp = tmp | (bit<<j);
            }
            set.add(tmp);
        }

        for (Integer x : set) {
            for (Integer x1 : set) {
                for (Integer x2 : set) {
                    int bit = x|x1|x2;
                    if (bit == (1<<5)-1) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
