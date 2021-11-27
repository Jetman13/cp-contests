package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ADominoDisaster {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- >0) {
            int n = in.nextInt();
            String str = in.nextLine();
            char[] chs =  str.toCharArray();
            char[] ans = new char[n];
            for (int i = 0; i < n; i++) {
                if (chs[i] == 'U') {
                    ans[i] = 'D';
                } else if (chs[i] == 'L'){
                    ans[i] = 'L';
                    ans[i+1] = 'R';
                } else if (chs[i] == 'D') {
                    ans[i] = 'U';
                }
            }
            out.println(new String(ans));
        }
    }
}
