package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class HHeavySort {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] h = new long[n];
        long[] w = new long[n];
        Arrays.setAll(h,i->in.nextLong());
        Arrays.setAll(w,i->in.nextLong());

        long ans = mergeSort(h,w,0,n-1);
        out.println(ans/2);

    }

    long mergeSort(long[] h,long[] w,int l,int r) {

        if (l >= r) return 0;

        int mid = (l+r)/2;

        long sum = mergeSort(h,w,l,mid);
        sum += mergeSort(h,w,mid+1,r);

        long[] tmph = new long[r-l+1];
        long[] tmpw = new long[r-l+1];
        long[] tmpsum = new long[r-l+2];
        for (int i = l; i <= r ; i++) {
            tmpsum[i-l+1] = tmpsum[i-l] + w[i];
        }

        int li = l;
        int ri = mid+1;
        int index = 0;

        while (li <= mid || ri <= r) {
            if (li > mid || (ri <= r && h[li] > h[ri])) {
                tmph[index] = h[ri];
                tmpw[index] = w[ri];
                sum += (tmpsum[mid-l+1] - tmpsum[li-l])*w[ri];
                index++;
                ri++;
            } else {
                tmph[index] = h[li];
                tmpw[index] = w[li];
                sum += (tmpsum[ri-l] - tmpsum[mid+1-l])*w[li];
                index++;
                li++;
            }
        }

        for (int i = l; i <=r ; i++) {
            h[i] = tmph[i-l];
            w[i] = tmpw[i-l];
        }

        return sum;
    }
}
