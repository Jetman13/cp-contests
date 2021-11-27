package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class DTeamsForming {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);
        RuffleSort.ruffleSort(a);

        int ans = 0;
        for (int i = 0; i < n; i=i+2) {
            ans += a[i+1]-a[i];
        }
        out.println(ans);

    }
}
