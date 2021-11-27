package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EGoodArray {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        in.readArr(a);
        long sum = Arrays.stream(a).sum();

        long[] sort = new long[n];
        Arrays.setAll(sort,i->a[i]);
        RuffleSort.ruffleSort(sort);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long remove = a[i];
            long max = sort[n-1] == a[i] ? sort[n-2] : sort[n-1];
            if (max == sum - max - a[i]) {
                list.add(i+1);
            }
        }
        out.println(list.size());
        for (Integer ans : list) {
            out.print(ans + " ");
        }
        out.println();

    }
}
