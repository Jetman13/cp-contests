package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class DStringSearching {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextLine());
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            StringBuilder sb = new StringBuilder(in.nextLine());
            int num = 0;
            Set<String> indexSet = new HashSet<>();
            for (int j = 0; j < sb.length(); j++) {
                String tmp = new StringBuilder(sb).deleteCharAt(j).toString();
                if (indexSet.contains(tmp)) continue;
                indexSet.add(tmp);
                if (set.contains(tmp)) {
                    num++;
                }
            }
            out.println(num);
        }

    }
}
