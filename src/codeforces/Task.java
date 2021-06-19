package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Task {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.nextLine();
        BigInteger bi = new BigInteger(s,2);
        String tmp = bi.toString(16);
        int[] ans = new int[1600];
        for (int i = 0; i < tmp.length(); i++) {
            ans[tmp.charAt(i)]++;
        }

        for (char i = '0'; i <= '9'; i++) {
            out.println(ans[i]);
        }
        for (char i = 'a'; i <= 'f' ; i++) {
            out.println(ans[i]);
        }

    }
}
