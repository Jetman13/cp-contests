package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class DGeniussGambit {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            sb.append("1");
        }
        for (int i = 0; i < a; i++) {
            sb.append("0");
        }
        if (k == 0) {
            out.println("Yes");
            out.println(sb.toString());
            out.println(sb.toString());
            return ;
        }
        if ((b == 1 || a == 0)) {
            out.println("No");
            return ;
        }
        if (k > a + b -2) {
            out.println("No");
            return;
        }

        out.println("Yes");
        out.println(sb.toString());

        int p = b-1;
        while (k > 0 && p < a+b-1) {
            swap(sb,p);
            k--;
            p++;
        }
        if (k == 0) {
            out.println(sb.toString());
            return ;
        }

        p = b - 2;
        while (p >= 0 && k > 0) {
            swap(sb,p);
            p--;
            k--;
        }
        out.println(sb.toString());

    }

    private void swap(StringBuilder sb, int p) {
        char tmp = sb.charAt(p);
        sb.setCharAt(p,sb.charAt(p+1));
        sb.setCharAt(p+1,tmp);
    }
}
