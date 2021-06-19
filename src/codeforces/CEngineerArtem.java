package codeforces;

import tool.FastReader;
import tool.Pair;

import java.io.PrintWriter;
import java.util.*;

public class CEngineerArtem {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            int[] a = new int[n];
            in.readArr(a);

            Arrays.sort(a);
            String ans = "NO";
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i-1]) {
                    ans = "YES";
                }
            }
            out.println(ans);

        }
    }
}
