package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DOpposite {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double d = in.nextDouble();

        double tmpk = Math.sqrt((c-a)*(c-a) + (d-b)*(d-b))/2.0;

        double k = tmpk*tmpk;

        double jiao = (180.0 * (n-1))/n;
        double k1 = Math.cos(Math.toRadians(jiao))*tmpk*2.0;



    }
}
