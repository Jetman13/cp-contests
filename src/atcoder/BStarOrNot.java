package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BStarOrNot {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] indu = new int[n+1];
        boolean flag = false;
        for (int i = 0; i < n-1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            indu[a]++;
            indu[b]++;
            if (indu[a] == n-1 || indu[b] == n-1) {
                flag = true;
            }
        }
        out.println(flag?"Yes":"No");

    }
}
