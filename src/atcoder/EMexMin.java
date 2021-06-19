package atcoder;

import tool.FastReader;
import tool.FenwichTree;
import tool.RangeTree;

import java.io.PrintWriter;

public class EMexMin {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);

        FenwichTree rt = new FenwichTree(new int[n]);

        int[] num = new int[n];
        for (int i = 0; i < m; i++) {
            num[a[i]]++;
            if (num[a[i]] == 1) {
                rt.update(a[i],1);
            }
        }

        int ans = cal(rt,n);
        for (int i = 0; i <= n-m; i++) {
            ans = Math.min(ans,cal(rt,n));
            if (i+m >= n) continue;
            if (num[a[i]] > 1) {
                num[a[i]]--;
            } else {
                num[a[i]]--;
                rt.update(a[i],0);
            }

            num[a[i+m]]++;
            if (num[a[i+m]] == 1) {
                rt.update(a[i+m],1);
            }
        }

        out.println(ans);


    }

    private int cal(FenwichTree rt, int n) {
        int l = 0;
        int r = n-1;
        int min = n;
        while (l <= r) {
            int mid = (l+r)/2;
            long sum = rt.sumRange(l,mid);
            if (sum >= mid-l+1) {
                l = mid + 1;
            } else {
                r = mid - 1;
                min = mid;
            }
        }
        return min;
    }
}
