package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AAlexeyAndTrain {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
            }

            int[] tm = new int[n];
            in.readArr(tm);

            int ans = 0;
            int pre = 0;
            for (int i = 0; i < n; i++) {
                int tmp = i==0?0:b[i-1];
                int start = a[i] - tmp + tm[i];

                int wait = (b[i]-a[i]+1)/2;

                int end = pre+start+wait >= b[i] ? pre+start+wait : b[i];



                if (n == i+1) {
                    ans = pre+start;
                }
                pre = end;
            }
            out.println(ans);
        }
    }
}
