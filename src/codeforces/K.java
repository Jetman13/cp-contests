package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class K {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            for (int j = 1; j < str.length()-1; j++) {
                if (str.charAt(j) == '-') ans++;
            }
        }
        out.println(ans);
    }
}
