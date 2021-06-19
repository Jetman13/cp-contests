package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class CTwoTeamsComposing {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n+1];
            for (int i = 0; i < n; i++) {
                int tmp = in.nextInt();
                a[tmp]++;
            }
            int num = 0;
            int disNum = 0;
            for (int i = 0; i <= n; i++) {
                if (a[i] > 0) disNum++;
            }
            for (int i = 1; i <= n ; i++) {
                if (a[i] <= 0) continue;
                int tmp = 0;
                if (a[i] > disNum) {
                    tmp = disNum;
                } else if (a[i] == disNum) {
                    tmp = disNum-1;
                } else {
                    tmp = a[i];
                }
                num = Math.max(num,tmp);
            }
            out.println(num);
        }
    }
}
