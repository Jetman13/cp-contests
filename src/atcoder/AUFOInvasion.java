package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AUFOInvasion {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String str = in.nextLine();
        int ans = 0;
        for (int i = 0; i < str.length()-3; i++) {
            if (str.startsWith("ZONe",i)) ans++;
        }
        out.println(ans);
    }
}
