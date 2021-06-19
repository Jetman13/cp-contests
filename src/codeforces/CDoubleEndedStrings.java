package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CDoubleEndedStrings {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            String a = in.nextLine();
            String b = in.nextLine();
            int len = a.length();
            int ans = a.length()+b.length();
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    String str = a.substring(i,j+1);
                    if (b.contains(str) ) {
                        ans = Math.min(ans,a.length() + b.length() - str.length()*2);
                    }
                }
            }
            out.println(ans);
        }
    }
}
