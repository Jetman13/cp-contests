package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class DSandasJob {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextLong();
        long s = in.nextLong();
        long b = s - a;
        if (b <= 0 || String.valueOf(a).length() != String.valueOf(b).length()) {
            out.println("NO");
            return ;
        }
        char[] cha = String.valueOf(a).toCharArray();
        char[] chb = String.valueOf(b).toCharArray();
        Arrays.sort(cha);
        Arrays.sort(chb);
        boolean f = true;
        for (int i = 0; i < cha.length; i++) {
            if (cha[i] != chb[i]) {
                f = false;
                break;
            }
        }
        out.println(f?"YES":"NO");
    }
}
