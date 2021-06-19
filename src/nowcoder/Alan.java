package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class Alan {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String tmp = in.nextLine();
            tmp = tmp.replace(" ","");
            if (tmp.contains("Alan")) {
                ans += cal(tmp);
            }
        }
        out.println(ans);
    }

    private int cal(String tmp) {
        int num = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '%') num++;
        }
        return num;
    }
}
