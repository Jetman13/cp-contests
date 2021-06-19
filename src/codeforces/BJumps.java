package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BJumps {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {

            int x = in.nextInt();
            int[] fac = new int[2021];
            fac[1] = 1;
            for (int i = 2; i < fac.length; i++) {
                fac[i] = fac[i-1] + i;
            }
            int index = 1;
            while (fac[index] < x) {
                index++;
            }
            if (x == fac[index]) {
                out.println(index);
            } else {
                int tmp = fac[index] - x - 1;
                if (tmp > 0) {
                    out.println(index);
                } else {
                    out.println(index + 1);
                }
            }

        }
    }
}
