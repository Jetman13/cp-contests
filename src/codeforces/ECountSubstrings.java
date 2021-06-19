package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ECountSubstrings {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.nextLine();
        String t = in.nextLine();
        if (n < 2) {
            out.println(0);
            return ;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == t.charAt(1) && s.charAt(i-1) == t.charAt(0)) {
                list.add(i);
            }
        }

        if (list.size() <= 0) {
            out.println(0);
            return ;
        }
        long ans = 0;
        int index = 0;
        for (int i = 0; i < n-1; i++) {
            while (index < list.size() && list.get(index) <= i) index++;
            if (index >= list.size()) continue;
            ans += n - list.get(index);
        }
        out.println(ans);

    }
}
