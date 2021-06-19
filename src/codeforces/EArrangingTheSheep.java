package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EArrangingTheSheep {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t -- > 0) {
            int n = in.nextInt();
            String s = in.nextLine();
            int num = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*') {
                    num++;
                    list.add(i);
                }
            }
            if (num == 0) {
                out.println(0);
                continue;
            }
            int mid = (num+1)/2;
            int p = 0;
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*') {
                    tmp++;
                    if (tmp == mid) {
                        p = i;
                        break;
                    }
                }
            }

            List<Integer> plist = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                if (i <= mid) {
                    plist.add(p - (mid - i));
                } else {
                    plist.add(p + (i-mid));
                }
            }

            long ans = 0;
            for (int i = 0; i < num; i++) {
                ans += Math.abs(plist.get(i) - list.get(i));
            }
            out.println(ans);



        }
    }
}
