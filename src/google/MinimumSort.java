package google;

import tool.FastReader;
import java.io.PrintWriter;

public class MinimumSort {
    int n = 0;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        if (testNumber == 1) {
            n = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            out.println("M "+i+" " + n);
            out.flush();
            int index = in.nextInt();
            if (index == i) continue;
            out.println("S " + i + " " + index);
            out.flush();
            int ans = in.nextInt();
            if (ans != 1) {

                return ;
            }

        }
        out.println("D");
        out.flush();
        int ans = in.nextInt();
        if (ans != 1) return ;
    }
}
