package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EPermutationBySum {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int s = in.nextInt();

            int min = (r - l + 1)*(r-l)/2;
            int tmp = (r - l + 1);
            int max = (n-tmp+1 + n)*tmp/2;

            if (s < min || s > max) {
                out.println(-1);
                continue;
            }

            boolean[] f = new boolean[n+1];
            int sum = 0;
            for (int i = 1; i <= tmp; i++) {
                f[i] = true;
                sum += i;
            }

            int p = n;
            for (int i = tmp; i >= 1; i--) {
                if (sum <= s) {
                    int k = s - sum;
                    if (i + k <= p) {
                        f[i] = false;
                        f[i+k] = true;
                        sum -= i;
                        sum += i+k;
                        break;
                    } else {
                        f[i] = false;
                        f[p] = true;
                        sum -= i;
                        sum += p;
                        p--;
                    }
                }
            }
            if (sum != s) {
                out.println(-1);
                continue;
            }
            List<Integer> list = new ArrayList<>();
            List<Integer> nolist = new ArrayList<>();
            for (int i = 1; i <= n ; i++) {
                if (f[i]) {
                    list.add(i);
                } else {
                    nolist.add(i);
                }
            }

            int[] ans = new int[n+1];
            int lp = 0;
            int nop = 0;
            for (int i = 1; i <= n ; i++) {
                if (i >= l && i <= r) {
                    if (lp < list.size())
                    ans[i] = list.get(lp++);
                } else {
                    if (nop < nolist.size())
                    ans[i] = nolist.get(nop++);
                }
            }

            for (int i = 1; i <= n; i++) {
                out.print(ans[i] + " ");
            }
            out.println();



        }
    }
}
