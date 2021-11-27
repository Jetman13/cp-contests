package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BMEXorMixup {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        int[] xor = new int[300003];
        for (int i = 1; i < 300001; i++) {
            xor[i] = xor[i-1] ^ i;
        }
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (xor[a-1] == b) {
                out.println(a);
            } else {
                if ((xor[a-1]^a) == b) {
                    out.println(a + 2);
                } else {
                    out.println(a + 1);
                }
            }
        }
    }
}
