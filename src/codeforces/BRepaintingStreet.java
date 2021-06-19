package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BRepaintingStreet {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0)  {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            int ans = n;
            for (int i = 1; i <= 100; i++) {
                int index = 0;
                int num = 0;
                while (index < n) {
                    while (index < n && a[index] == i) {
                        index++;
                    }
                    if (index >= n) break;
                    num++;
                    index = index+k;
                }
                ans = Math.min(ans,num);
            }
            out.println(ans);
        }
    }
}
