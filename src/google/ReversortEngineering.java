package google;

import tool.FastReader;
import tool.Permutation;

import java.io.PrintWriter;
import java.util.Arrays;

public class ReversortEngineering {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int c = in.nextInt();
        int[] a = new int[n];
        Arrays.setAll(a,i->(i+1));
        Permutation pm = new Permutation();
        Reversort reversort = new Reversort();
        boolean ans = false;
        do {
            int[] tmp = Arrays.copyOf(a,n);
            if (reversort.getAns(tmp) == c) {
                ans = true;
                break;
            }
        } while (pm.next(a));
        if (!ans) {
            out.println("Case #" + testNumber + ": IMPOSSIBLE");
        } else {
            out.print("Case #" + testNumber + ":");
            for (int i = 0; i < n; i++) {
                out.print(" " + a[i]);
            }
            out.println();
        }
    }
}
