package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CStringInvasion {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();
        int len = s.length();
        int[] num = new int[30];
        num[s.charAt(len-1)-'a']++;
        long ans = 0;
        for (int i = len-3; i >= 0 ; i--) {
            if (s.charAt(i) == s.charAt(i+1) && s.charAt(i) != s.charAt(i+2)) {
                ans += Arrays.stream(num).sum() - num[s.charAt(i) - 'a'];
                Arrays.fill(num,0);
                num[s.charAt(i)-'a'] = len-i-1;
            } else {
                num[s.charAt(i+1)-'a']++;
            }
        }
        out.println(ans);
    }
}
