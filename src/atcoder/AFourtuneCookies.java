package atcoder;

import javafx.util.Pair;
import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AFourtuneCookies {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long[] a = new long[4];
        long sum = 0;
        for (int i = 0; i < 4; i++) {
            a[i] = in.nextLong();
            sum+=a[i];
        }
        Arrays.sort(a);
        if (sum %2 != 0) {
            out.println("No");
            out.flush();
            return ;
        }
        if (a[0] + a[1] + a[2] == sum/2) {
            out.println("Yes");
        } else if (a[0] + a[2] == sum/2) {
            out.println("Yes");
        } else if (a[0] + a[1] == sum/2) {
            out.println("Yes");
        } else if (a[1] + a[2] == sum/2) {
            out.println("Yes");
        } else {
            out.println("No");
        }
        out.flush();

    }
}
