package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class APhoenixAndGold {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            int sum = Arrays.stream(a).sum();
            if (sum == x) {
                out.println("NO");
                continue;
            }
            out.println("YES");
            Arrays.sort(a);
            
            int s = 0;
            for (int i = 0; i < a.length; i++) {
                if (s + a[i] == x) {
                    int tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                }
                s+=a[i];
            }
            for (int i = 0; i < a.length; i++) {
                out.print(a[i] + " ");
            }
            out.println();
            
        }
    }
}
