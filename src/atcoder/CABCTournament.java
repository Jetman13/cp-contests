package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CABCTournament {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int num = (1<<n);
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = in.nextInt();
        }

        int mid = num/2;
        int l = 0;
        int min = -1;
        for (int i = 0; i < mid; i++) {
            if (a[i] > min) {
                min = a[i];
                l = i+1;
            }
        }
        int r = 0;
        min = -1;
        for (int i = mid; i < num; i++) {
            if (a[i] > min) {
                min = a[i];
                r = i + 1;
            }
        }
        out.println(a[l-1] < a[r-1] ? l : r);
    }
}
