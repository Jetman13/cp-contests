package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CEhabAndPrefixMEXs {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        boolean[] f = new boolean[1000002];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            f[a[i]] = true;
            if (i == 0 || a[i]!=a[i-1]) {
                list.add(a[i]);
            }
        }

        int r = -1;
        int p = 0;
        int[] b = new int[n];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (r < a[i]-2) {
                flag = false;
                break;
            } else {
                if (i > 0 && a[i] != a[i-1]) {
                    b[i] = list.get(p);
                    p++;
                    r = Math.max(r,b[i]);
                } else {
                    r++;
                    while (f[r]) r++;
                    b[i] = r;
                }

                if (p < list.size() && list.get(p) != a[i]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            for (int i = 0; i <n; i++) {
                out.print(b[i] + " ");
            }
            out.println();
        } else {
            out.println(-1);
        }

    }
}
