package facebook;

import tool.FastReader;
import java.io.PrintWriter;

public class A1WeakTypingChapter1 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int[] chs = new int[300];
        chs['X'] = 1;
        chs['O'] = 0;
        int t = in.nextInt();
        for (int test = 1; test <= t ; test++) {
            int n = in.nextInt();
            String str = in.nextLine();
            int ans = n;
            for (int k = 0; k < 2; k++) {

                int p = k;
                int min = 0;
                for (int i = 0; i < n; i++) {
                    if (str.charAt(i) == 'F') continue;
                    if (chs[str.charAt(i)] != p) {
                        min++;
                        p ^= 1;
                    }
                }
                ans = Math.min(min,ans);
            }
            out.println("Case #" + test + ": " + ans);
        }
    }
}
