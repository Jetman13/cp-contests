package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class FGameOnGrid {
    String bob = "Bob";
    String alice = "Alice";
    String draw = "Draw";
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            if (n == 1 || n == 3) {
                out.println(bob);
                continue;
            } else if (n == 2){
                out.println(alice);
                continue;
            } else if (n == 4) {
                out.println(draw);
                continue;
            }
            if (n%2 != 0) {
                out.println(bob);
                continue;
            }
            int tmp = n*n;
            if ((tmp/4)%2 != 0) {
                out.println(alice);
                continue;
            }
            out.println(draw);
//            int a = ((tmp/4)/4) * 4;
//            int b = tmp -a;
//            if (a > b) {
//                out.println(alice);
//            } else if (a == b) {
//                out.println(draw);
//            } else {
//                out.println(bob);
//            }

//            if (n % 2 == 0) {
//                out.println(alice);
//            } else {
//                out.println(bob);
//            }
        }

    }
}
