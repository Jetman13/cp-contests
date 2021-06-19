package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BOrdinaryNumbers {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        List<Long> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10 ; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < i; k++) {
                    sb.append(j);
                }
                list.add(Long.valueOf(sb.toString()));
            }
        }
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            int p = 0;
            while (p < list.size() && list.get(p) <= n) p++;
            out.println(p);
        }
    }
}
