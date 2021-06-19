package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CCats {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int index = 2;
        while (n > list.size()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                tmp.add(index);
                tmp.add(list.get(i));
            }
            tmp.add(index);
            list = tmp;
            index++;
        }
        for (int i = 0; i < n; i++) {
            out.print(list.get(i) + " ");
        }
        out.println();
    }
}
