package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Cg {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        String[][] ans = new String[n][5];
        for (int i = 0; i < n; i++) {
            ans[i][0] = in.next();
            ans[i][1] = in.next();
            ans[i][2] = in.next();
            ans[i][3] = in.next();
            ans[i][4] = i + "";
        }

        Arrays.sort(ans,(a,b) -> {
            if (a[0].length() != b[0].length()) {
                return a[0].length() - b[0].length();
            }
            if (a[0].equals(b[0])) {
                return Integer.parseInt(a[4]) - Integer.parseInt(b[4]);
            }
            return a[0].compareTo(b[0]);
        });

        for (int i = 0; i < n; i++) {
            out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2]+ " " + ans[i][3]);
        }
        
    }
}
