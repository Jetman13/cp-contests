package facebook;

import tool.FastReader;
import java.io.PrintWriter;

public class A1ConsistencyChapter1 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int ca = 1; ca <= t; ca++) {

            String str = in.nextLine();
            boolean[] flag = new boolean[300];
            flag['A'] = true;
            flag['E'] = true;
            flag['I'] = true;
            flag['O'] = true;
            flag['U'] = true;
            int ans = Integer.MAX_VALUE;
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                int num = 0;
                for (int i = 0; i < str.length(); i++) {
                    char tmp = str.charAt(i);
                    if (tmp == ch) continue;
                    if (flag[tmp] != flag[ch]) {
                        num++;
                    } else {
                        num += 2;
                    }
                }
                ans = Math.min(ans, num);
            }
            out.println("Case #" + ca + ": " + ans);
        }
    }
}
