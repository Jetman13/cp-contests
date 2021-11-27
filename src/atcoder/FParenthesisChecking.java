package atcoder;

import tool.FastReader;
import tool.RangeTree;

import java.io.PrintWriter;

public class FParenthesisChecking {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        String s = in.nextLine();
        RangeTree rt = new RangeTree(s.length()+1);
        int sum = 0;
        int[] a = new int[n+1];
        for (int i = 0; i < s.length(); i++) {
            a[i+1] = (s.charAt(i) == '(') ? 1 : -1;
            sum += a[i+1];
            rt.update(i+1,i+1,sum);
        }
        for (int i = 0; i < q; i++) {
            int p = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            if (p == 1) {
                if (l == r || a[l] == a[r]) continue;

                rt.update(l,r-1,a[r] - a[l]);
                int tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
            } else {
                if (rt.minQuery(l,r) - rt.sumQuery(l-1,l-1) == 0 && rt.sumQuery(r,r) - rt.sumQuery(l-1,l-1) == 0) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
            }
        }
    }
}
