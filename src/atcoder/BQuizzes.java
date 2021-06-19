package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BQuizzes {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long n = in.nextLong();
        long x = in.nextLong();
        String s = in.nextLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'o') {
                x++;
            } else {
                if (x > 0) {
                    x--;
                }
            }
        }
        out.println(x);

    }
}
