package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CJohnKatyaNoNuts {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextInt();
        long b = in.nextInt();
        long abs = Math.abs(a-b) + 1;
        if (a - abs >= 0) {
            out.println(0);
        } else {
            out.println(a+abs);
        }
    }
}
