package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DParking {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        String tmp = in.nextLine() + "1";


        List<Integer> ansa = new ArrayList<>();
        List<Integer> ansb = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (a > 0 && tmp.charAt(i) == '0' && tmp.charAt(i+1) == '0') {
                a--;
                ansa.add(i+1);
                i++;
            } else if (b > 0 && tmp.charAt(i) == '0') {
                b--;
                ansb.add(i+1);
            }
        }

        if (a > 0 || b > 0) {
            out.println("NO");
        } else {
            out.println("YES");
            for (int i = 0; i < ansa.size(); i++) {
                out.println(ansa.get(i) + " " + (ansa.get(i)+1));
            }
            for (int i = 0; i < ansb.size(); i++) {
                out.println(ansb.get(i));
            }
        }

    }
}
