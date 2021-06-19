package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class DXORGame {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            boolean ans = false;


            while (a != 0 || b != 0) {
                int c = a%2;
                int d = b%2;
                if ((c&d) > 0) {
                    ans = true;
                    break;
                }
                a/=2;
                b/=2;
            }

            out.println(ans ? "Yes":"No");


        }
    }
}
