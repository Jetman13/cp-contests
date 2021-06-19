package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A2PrefixFlipHardVersion {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int len = in.nextInt();
            String s = in.nextLine();
            String e = in.nextLine();
            if (e.equals(s)) {
                out.println(0);
                continue;
            }

            int[] a = new int[len];
            int[] b = new int[len];
            for (int i = 0; i < len; i++) {
                a[i] = s.charAt(i) - '0';
                b[i] = e.charAt(i) - '0';
            }

            int l = 0;
            int r = len-1;
            int mod = 0;
            List<Integer> ans = new ArrayList<>();

            for (int i = len-1; i >= 0 ; i--) {
                int p = mod == 0 ? l++ : r--;
                int val = (a[p]+mod)%2;
                mod = (mod+1)%2;
                if (val == b[i]) {
                    ans.add(1);
                }
                ans.add(i+1);
            }

            out.print(ans.size() + " ");
            for (Integer an : ans) {
                out.print(an + " ");
            }
            out.println();

        }
    }
}
