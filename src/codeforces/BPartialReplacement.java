package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BPartialReplacement {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String str = in.nextLine();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '*') {
                    list.add(i);
                }
            }

            if (list.size() <= 2) {
                out.println(list.size());
                continue;
            }

            int pre = list.get(0);
            int num = 1;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) - pre > k) {
                    pre = list.get(j-1);
                    num++;
                } else {

                }
            }
            if (pre != list.get(list.size()-1)) num++;
            out.println(num);

        }
    }
}
