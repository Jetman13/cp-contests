package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BCardDeck {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            int[] p = new int[n+1];
            for (int i = 0; i < n; i++) {
                p[a[i]] = i;
            }

            List<Integer>  ans = new ArrayList<>();
            boolean[] flag = new boolean[n+2];
            for (int i = n; i > 0 ; i--) {
                if (flag[p[i]]) continue;

                int point = p[i];
                while (!flag[point] && point < n) {
                    flag[point] = true;
                    ans.add(a[point]);
                    point++;
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

        }
    }
}
