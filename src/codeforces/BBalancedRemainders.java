package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BBalancedRemainders {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            int[] c = new int[3];
            for (int i = 0; i < n; i++) {
                c[a[i]%3]++;
            }
            int num = n/3;
            int ans = 0;
            for (int i = 0; i < 6; i++) {
                int index = i%3;
                if (c[index] > num) {
                    int tmp = c[index]-num;
                    ans+=tmp;
                    c[index]-=tmp;
                    c[(index+1)%3]+=tmp;
                }
            }
            out.println(ans);
        }
    }
}
