package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AFirstGrid {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String[] str = new String[2];
        for (int i = 0; i < 2; i++) {
            str[i] = in.nextLine();
        }

        int k = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (str[i].charAt(j) == '#') k++;
            }
        }
        if (k == 2) {
            if (str[0].charAt(0) == str[1].charAt(1) && str[0].charAt(0) == '#') {
                out.println("No");
            } else if (str[0].charAt(1) == str[1].charAt(0) && str[0].charAt(1) == '#') {
                out.println("No");
            } else {
                out.println("Yes");
            }
        } else {
            out.println("Yes");
        }

    }
}
