package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class BSameName {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        Set<String> set = new HashSet<>();
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            String name = in.next() + "_" + in.next();
            if (set.contains(name)) {
                ans = true;
                break;
            }
            set.add(name);
        }
        out.println(ans ? "Yes":"No");
    }
}
