package codechef;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class SpaceArrays {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            RuffleSort.ruffleSort(a);

            long num = 0;
            boolean ans = true;
            for (int i = 0; i < n; i++) {
                if (i+1 < a[i]) {
                    ans = false;
                    break;
                } else {
                    num += i+1-a[i];
                }
            }
            if (!ans) {
                out.println("Second");
            } else {
                out.println(num%2==1 ? "First":"Second");
            }
        }
    }
}
