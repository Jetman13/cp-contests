package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CMaximumWidth {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        String s = in.nextLine();
        String t = in.nextLine();

        int[] dpl = new int[m+2];
        int[] dpr = new int[m+2];

        int p = 0;
        for (int i = 0; i < s.length() && p < t.length(); i++) {
            if (s.charAt(i) != t.charAt(p)) continue;

            dpl[p+1] = i+1;
            p++;
        }

        p = t.length()-1;
        for (int i = s.length()-1; i >=0 && p >= 0 ; i--) {
            if (s.charAt(i) != t.charAt(p)) continue;

            dpr[p+1] = i+1;
            p--;
        }

        int ans = 1;
        for (int i = 1; i < m ; i++) {
            ans = Math.max(ans,dpr[i+1] - dpl[i]);
        }
        out.println(ans);

    }
}
