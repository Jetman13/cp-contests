package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class Easy {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.nextLine();
        int[] num = new int[n+3];
        for (int i = 1; i < n; i++) {
            num[i+1] = num[i];
            if (s.charAt(i-1) == 'B' && s.charAt(i) == 'A') {
                num[i+1]++;
            }
        }

        int l = 1;
        int r = 1;
        int ans = 1;
        while (r <= n) {
            if (num[r] - num[l] < 2) {
                ans = Math.max(ans,r-l+1);
                r++;
                continue;
            }
            while (num[r] - num[l] > 1) {
                l++;
            }
            ans = Math.max(ans,r-l+1);

        }
        out.println(ans);

    }
}
