package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BCanYouBuyThemAll {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            if (i%2==1) {
                sum+=tmp-1;
            } else {
                sum+=tmp;
            }
        }
        out.println(sum > x ? "No" : "Yes");
    }
}
