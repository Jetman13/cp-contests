package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CABPalindrome {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            String s = in.nextLine();
            char[] chs = s.toCharArray();
            int len = chs.length;
            for (int i = 0; i < chs.length/2; i++) {
                char l = chs[i];
                char r = chs[len-i-1];
                if (l == r && l == '?') continue;

                if (l == '?') {
                    chs[i] = chs[len-i-1];
                }
                if (r == '?') {
                    chs[len-i-1] = chs[i];
                }
            }

            int one = 0;
            int zero = 0;
            for (int i = 0; i < len; i++) {
                if (chs[i] == '0') zero++;
                if (chs[i] == '1') one++;
            }

            if (one > b || zero > a) {
                out.println("-1");
                continue;
            }
            for (int i = 0; i < len/2; i++) {
                if (chs[i] == '?') {
                    if (one +2 <= b) {
                        chs[i] = chs[len-i-1] = '1';
                        one+=2;
                    } else if (zero + 2 <= a) {
                        chs[i] = chs[len-i-1] = '0';
                        zero += 2;
                    }
                }
            }

            if (len%2 == 1 && chs[len/2] == '?') {
                if (one + 1 <= b) {
                    chs[len/2] = '1';
                } else if (zero + 1 <= a) {
                    chs[len/2] = '0';
                }
            }

            boolean f = true;
            for (int i = 0; i < len; i++) {
                if (chs[i] == '?') {
                    f = false;
                    break;
                }
            }
            for (int i = 0; i < len/2; i++) {
                if (chs[i] != chs[len-i-1]) {
                    f = false;
                    break;
                }
            }
            if (!f) {
                out.println(-1);
            } else {
                for (int i = 0; i < len; i++) {
                    out.print(chs[i]);
                }
                out.println();
            }



        }
    }
}
