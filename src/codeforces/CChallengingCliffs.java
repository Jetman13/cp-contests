package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CChallengingCliffs {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            RuffleSort.ruffleSort(a);

            int p = 0;
            int max = a[1] - a[0];
            for (int i = 1; i < n-1; i++) {
                int tmp = a[i+1] - a[i];
                if (tmp < max) {
                    max = tmp;
                    p = i;
                }
            }

            List<Integer> list = new ArrayList<>();
            list.add(a[p]);
            for (int i = p+2; i < n; i++) {
                list.add(a[i]);
            }
            for (int i = 0; i < p; i++) {
                list.add(a[i]);
            }
            list.add(a[p+1]);
            for (int i = 0; i < n; i++) {
                out.print(list.get(i) + " ");
            }
            out.println();
        }
    }
}
