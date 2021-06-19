package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ACardsForFriends {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int w = in.nextInt();
            int h = in.nextInt();
            int n = in.nextInt();
            int num1 = 0;
            int num2 = 0;
            while (w%2==0) {
                num1++;
                w/=2;
            }
            while (h%2==0) {
                num2++;
                h/=2;
            }

            long num = (1<<num1)*(1<<num2);
            out.println(num >= n ? "YES":"NO");

        }
    }
}
