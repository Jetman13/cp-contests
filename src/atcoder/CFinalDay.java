package atcoder;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CFinalDay {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> b = new ArrayList<>();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            a[i] += in.nextInt();
            a[i] += in.nextInt();
            b.add(a[i]);
        }
        b.add(1000);

        Collections.sort(b);



        for (int i = 0; i < n; i++) {
            int tmp = a[i] + 300;
            int l = 0;
            int r = n;
            while (l < r) {
                int mid = (l+r)/2;
                if (b.get(mid) > tmp) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (n - l + 1 <= k) {
                out.println("Yes");
            } else {
                out.println("No");
            }

        }


    }
}
