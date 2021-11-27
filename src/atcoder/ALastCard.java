package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ALastCard {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();


        for (int i = 0; i < k-1; i++) {
            a++;
            if (a == n+1) {
                a = 1;
            }
        }
        out.println(a);
    }
}
