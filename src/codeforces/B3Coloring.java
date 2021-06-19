package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class B3Coloring {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        int[][] a = new int[n+2][n+2];
        for (int i = 0; i < n+2; i++) {
            Arrays.fill(a[i],-1);
        }


        int one = 0;
        int two = 1;
        int[] change = new int[]{0,2,1,1};
        for (int i = 0; i < n*n; i++) {
            int c = in.nextInt();
            int k = change[c];
            if (k == 1 && one < n*n) {
                out.println(k + " " + (one/n+1) + " " + ((one%n)+1));
                out.flush();
                one = getNext(one,n,0);
            } else if (k == 2 && two < n*n){
                out.println(k + " " + (two/n+1) + " " + ((two%n)+1));
                out.flush();
                two = getNext(two,n,1);
            } else {
                if (one < n*n) {
                    if (c == 3) {
                        k = 1;
                    } else {
                        k = 3;
                    }
                    out.println(k + " " + (one/n+1) + " " + ((one%n)+1));
                    out.flush();
                    one = getNext(one,n,0);
                } else {
                    if (c == 3) {
                        k = 2;
                    } else {
                        k = 3;
                    }
                    out.println(k + " " + (two/n+1) + " " + ((two%n)+1));
                    out.flush();
                    two = getNext(two,n,1);
                }
            }
        }



    }

    private int getNext(int tmp,int n, int mod) {
        while (true) {
            tmp++;
            int l = tmp/n;
            int r = tmp%n;
            if ((l+r)%2 == mod) return tmp;
        }
    }
}
