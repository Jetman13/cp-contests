package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ARemoveDuplicates {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);
        boolean[] f = new boolean[1002];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = n-1; i >=0 ; i--) {
            if (!f[a[i]]) {
                list.add(a[i]);
            }
            f[a[i]] = true;
        }
        out.println(list.size());
        for (int i = list.size()-1; i >=0 ; i--) {
            out.print(list.get(i) + " ");
        }
        out.println();
    }
}
