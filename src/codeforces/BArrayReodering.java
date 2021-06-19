package codeforces;

import tool.CommonUtils;
import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BArrayReodering {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            List<Integer> one = new ArrayList<>();
            List<Integer> two = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i]%2==0) {
                    one.add(a[i]);
                } else {
                    two.add(a[i]);
                }
            }
            two.addAll(one);


            int ans = 0;
            for (int i = n-1; i > 0 ; i--) {
                for (int j = 0; j < i; j++) {
                    if (CommonUtils.gcd(two.get(i),two.get(j)*2) > 1) {
                        ans++;
                    }
                }
            }
            out.println(ans);

        }
    }
}
