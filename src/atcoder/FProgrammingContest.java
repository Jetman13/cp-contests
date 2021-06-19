package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class FProgrammingContest {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        long t = in.nextLong();
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        List<Long> llist = new ArrayList<>();
        int lnum = n/2;
        for (int i = 0; i < (1<<lnum); i++) {
            long tmp = 0;
            for (int j = 0; j < lnum; j++) {
                if (((1<<j)&i) > 0) {
                    tmp+=a[j];
                }
            }
            llist.add(tmp);
        }
        long ans = 0;
        Collections.sort(llist);
        int rnum = n - lnum;
        for (int i = 0; i < (1<<rnum); i++) {
            long tmp = 0;
            for (int j = 0; j < rnum; j++) {
                if (((1<<j)&i) > 0) {
                    tmp+=a[j+lnum];
                }
            }

            if (tmp > t) continue;

            int l = 0;
            int r = llist.size()-1;
            while (l <= r) {
                int mid = (l+r)/2;
                if (llist.get(mid) + tmp <= t) {
                    ans = Math.max(ans,llist.get(mid)+tmp);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }




        }

        out.println(ans);

    }
}
