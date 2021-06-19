package google;

import tool.FastReader;
import java.io.PrintWriter;

public class Reversort {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);

        int ans = getAns( a);
        out.println("Case #" + testNumber + ": " + ans);

    }

    public int getAns(int[] a) {
        int n = a.length;
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            int min = a[i];
            int p = i;
            for (int j = i; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    p = j;
                }
            }
            ans += p - i + 1;
            reverse(a,i,p);
        }
        return ans;
    }

    private void reverse(int[] a, int s, int e) {
        while (s < e) {
            int tmp = a[s];
            a[s] = a[e];
            a[e] = tmp;
            s++;
            e--;
        }
    }
}
