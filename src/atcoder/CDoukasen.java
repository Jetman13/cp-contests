package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CDoukasen {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        double[] a = new double[n];
        double[] b = new double[n];
        double len = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextDouble();
            b[i] = in.nextDouble();
            len += a[i];
        }

        double l = 0;
        double r = 100000001;
        for (int i = 0; i < 100; i++) {
            double mid = (l + r)/2.0;
            double llen = getL(mid,a,b);
            double rlen = getR(mid,a,b);
            if (llen + rlen > len) {
                r = mid;
            } else {
                l = mid;
            }
        }
        out.println(getL(l,a,b));

    }

    private double getR(double mid, double[] a, double[] b) {
        int n = a.length;
        double len = 0;
        for (int i = n-1; i >= 0; i--) {
            double t = a[i]/b[i];
            if (mid >= t) {
                mid-=t;
                len += a[i];
            } else {
                len += mid*b[i];
                break;
            }
        }
        return len;
    }

    private double getL(double mid, double[] a, double[] b) {
        int n = a.length;
        double len = 0;
        for (int i = 0; i < n; i++) {
            double t = a[i]/b[i];
            if (mid >= t) {
                mid-=t;
                len += a[i];
            } else {
                len += mid*b[i];
                break;
            }
        }
        return len;
    }
}
