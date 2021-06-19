package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FTheTreasureOfTheSegments {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[][] larr = new int[n][2];
            int[][] rarr = new int[n][2];
            for (int i = 0; i < n; i++) {
                larr[i][0] = rarr[i][0] = in.nextInt();
                larr[i][1] = rarr[i][1] = in.nextInt();
            }
            Arrays.sort(larr,(a,b)->a[0]-b[0]);
            Arrays.sort(rarr,(a,b)->a[1]-b[1]);

            int ans = n+1;
            for (int i = 0; i < n; i++) {
                int l = larr[i][0];
                int r = larr[i][1];
                int tmp = calL(rarr,l) + calR(larr,r);
                ans = Math.min(ans,tmp);
            }
            out.println(ans);
        }
    }

    private int calR(int[][] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int ans = 0;
        while (l <= r) {
            int mid = (l+r)/2;
            if (arr[mid][0] > k) {
                ans = n - mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int calL(int[][] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int ans = 0;
        while (l <= r) {
            int mid = (l+r)/2;
            if (arr[mid][1] < k) {
                ans = mid+1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
