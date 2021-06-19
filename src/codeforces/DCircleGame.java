package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class DCircleGame {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long d = in.nextLong();
            long k = in.nextLong();
            double num = d/Math.sqrt(2.0*k*k);

            if (Math.abs(num - Math.floor(num)) < 0.00001) {
                out.println("Utkarsh");
                continue;
            }

            double x = Math.floor(num)*k + k;
            double y = Math.floor(num)*k;
            if (x*x + y*y > d*d) {
                out.println("Utkarsh");
            } else {
                out.println("Ashish");
            }


        }
    }
}
