package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BBerlandCrossword {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[4];
            in.readArr(a);
            if (n == 1) {
                int sum = Arrays.stream(a).sum();
                if (sum == 0 || sum == 4) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
                continue;
            }

            boolean flag = false;
            for (int i = 0; i < (1<<4); i++) {
                int[] b = new int[4];
                for (int j = 0; j < 4; j++) {
                    if ((i&(1<<j)) > 0) {
                        b[j] = 1;
                    }
                }

                boolean ans = true;
                for (int j = 0; j < 4; j++) {
                    int next = (j+1)%4;
                    if (b[j] + b[next] > a[j] || b[j] + b[next] + n - 2 < a[j]) {
                        ans = false;
                        break;
                    }
                }
                if (ans) {
                    flag = true;
                    break;
                }
            }

            out.println(flag ? "YES":"NO");

        }
    }
}
