package quora;

import tool.FastReader;
import tool.RangeTree;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Task {
    int MOD = (int)1e9 + 7;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        RangeTree rt = new RangeTree(n+1);
        for (int i = 1; i <= n; i++) {
            rt.update(i,i,in.nextLong());
        }

        for (int i = 0; i < q; i++) {
            int op = in.nextInt();
            if (op == 1) {
                int index = in.nextInt();
                long val = rt.sumQuery(index,index);
                out.println(call(1,index-1,rt,val) + calr(index+1,n,rt,val) + 1);

            } else if (op == 2) {
                int l = in.nextInt();
                long val = in.nextLong();
                rt.update(l,l,val - rt.sumQuery(l,l));
            } else {
                int l = in.nextInt();
                int r = in.nextInt();
                long val = in.nextLong();
                for (int j = l; j <= r ; j++) {
                    rt.update(j,j,val - rt.sumQuery(j,j));
                }
            }
        }


    }

    private int call(int l, int r, RangeTree rt, long val) {
        int index = r;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r)/2;
            long tmp = rt.maxQuery(mid,index);
            if (tmp > val) {
                l = mid + 1;
            } else {
                ans = index - mid + 1;
                r = mid - 1;
            }
        }
        return ans;
    }
    private int calr(int l, int r, RangeTree rt, long val) {
        int index = l;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r)/2;
            long tmp = rt.maxQuery(index,mid);
            if (tmp > val) {
                r = mid - 1;
            } else {
                ans = mid - index + 1;
                l = mid + 1;
            }
        }
        return ans;
    }
}
