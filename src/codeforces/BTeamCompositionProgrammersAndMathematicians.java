package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BTeamCompositionProgrammersAndMathematicians {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            long a = in.nextLong();
            long b = in.nextLong();
            if (a < b) {
                long tmp = a;
                a = b;
                b = tmp;
            }

            if (a >= b*3) {
                out.println(b);
            } else {
                out.println((a+b)/4);
            }

        }
    }
}
