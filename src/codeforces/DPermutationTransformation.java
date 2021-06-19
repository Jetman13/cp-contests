package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class DPermutationTransformation {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            int[] ans = new int[n];
            work(a,ans,0,n-1,0);
            for (int i = 0; i < n; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }
    }

    private void work(int[] a, int[] ans, int l, int r,int h) {
        if (l > r) return ;
        int index = l;
        int val = a[l];
        for (int i = l+1; i <= r ; i++) {
            if (a[i] > a[index]) {
                index = i;
                val = a[i];
            }
        }

        ans[index] = h;
        work(a,ans,l,index-1,h+1);
        work(a,ans,index+1,r,h+1);
    }
}
