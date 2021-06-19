package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class E1ReadingBooksEasyVersion {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> all = new ArrayList<>();
        List<Integer> alist = new ArrayList<>();
        List<Integer> blist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if (a+b == 2) {
                all.add(t);
            } else if (a == 1) {
                alist.add(t);
            } else if (b == 1) {
                blist.add(t);
            }
        }
        all.sort(Comparator.naturalOrder());
        alist.sort(Comparator.naturalOrder());
        blist.sort(Comparator.naturalOrder());
        int[] aSum = new int[alist.size()+1];
        int[] bSum = new int[blist.size()+1];
        int[] allSum = new int[all.size()+1];
        for (int i = 1; i <= all.size(); i++) {
            allSum[i] = allSum[i-1] + all.get(i-1);
        }
        for (int i = 1; i <= alist.size(); i++) {
            aSum[i] = aSum[i-1] + alist.get(i-1);
        }
        for (int i = 1; i <= blist.size(); i++) {
            bSum[i] = bSum[i-1] + blist.get(i-1);
        }
        if (all.size() + alist.size() < k || all.size() + blist.size() < k) {
            out.println(-1);
            return ;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= all.size(); i++) {
            if (i + alist.size() < k || i + blist.size() < k) {
                continue;
            }
            if (i >= k) {
                ans = Math.min(ans,allSum[i]);
                break;
            }
            ans = Math.min(ans,allSum[i]+aSum[k-i]+bSum[k-i]);
        }
        out.println(ans);
    }
}
