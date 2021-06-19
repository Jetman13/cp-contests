package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CStringEquality {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String astr = in.nextLine();
            String bstr = in.nextLine();
            int[] a = new int[30];
            int[] b = new int[30];
            for (int i = 0; i < n; i++) {
                a[astr.charAt(i)-'a']++;
            }
            for (int i = 0; i < n; i++) {
                b[bstr.charAt(i)-'a']++;
            }

            boolean f = true;
            for (int i = 0; i < 26; i++) {
                if (a[i] < b[i]) {
                    f = false;
                    break;
                }
                if ((a[i]-b[i])%k != 0) {
                    f = false;
                    break;
                }
                a[i+1] += a[i] - b[i];
            }
            out.println(f ? "Yes":"No");

        }
    }
}
