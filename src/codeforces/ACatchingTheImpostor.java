package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ACatchingTheImpostor {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        boolean[] flag = new boolean[n+1];
        for (int i = 0; i < k; i++) {
            flag[in.nextInt()] = true;
        }
        int num = 0;
        for (int i = 1; i <= n ; i++) {
            if (!flag[i]) num++;
        }
        out.println((num > 1 || num == 0) ?"NO":"YES");
    }
}
