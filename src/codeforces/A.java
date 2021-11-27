package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] b = new int[m];
        in.readArr(b);

        boolean l = checkL(a,x,y,b);
        boolean r = checkR(a,x,y,b);
        if (l && r) {
            out.println("Unsure");
        } else if ((l && (x > y)) || (r && (x < y))) {
            out.println("Right");
        } else {
            out.println("Wrong");
        }

    }

    private boolean checkR(int[] a, int x, int y, int[] b) {
        if (a.length-1 - x < b.length) return false;

        for (int i = 1; i <= b.length; i++) {
//            if (x+i >= a.length) return false;
            if (b[i-1] != a[x+i]) return false;
        }
        return true;
    }

    private boolean checkL(int[] a, int x, int y, int[] b) {
        if (x - 1 < b.length) return false;

        for (int i = 1; i <= b.length; i++) {
            if (b[i-1] != a[x-i]) return false;
        }
        return true;
    }
}
