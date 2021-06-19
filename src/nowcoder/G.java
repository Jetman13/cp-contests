package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class G {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

//        long[] f = new long[10000];
//        for (int i = 1; i < 100; i++) {
//            for (int j = 1; j <= i ; j++) {
//                f[i] += (i%j==0) ? j : 0;
//            }
//        }
//
//        long[] g = new long[10000];
//        for (int i = 1; i <100 ; i++) {
//            g[i] = g[i-1] + f[i];
//        }
////
//        for (int i = 1; i < 100; i++) {
////            out.println("g[" + i +"]" + g[i]);
//            out.println(g[i] == calG(i));
//        }

        //1424354837450309773
        //3477351033916669850
        out.println(calG(calG(in.nextInt())));
//        out.println(calG(500000000));

        int tmp = 100;
//        for (int i = 1; i <= tmp ; i++) {
//            out.println(tmp + "/" + i + "=" + tmp/i);
//        }


    }


    long calG(long num) {
        long sum = 0;
        long tmp = num;
        long k = 1;
        long l,r;
        do {
            r = (long) Math.floor(num / (double) k);
            l = (long) Math.ceil(num / (double) (k + 1));
            if (num%(k+1) == 0) l++;
            if (l > r) {
                break;
            }

            tmp = l-1;
            sum += ((r-l+1)*(l+r)/2)*(num/l);
            k++;

        } while (true);

        for (long i = tmp; i >= 1 ; i--) {
            sum += i*(num/i);
        }
        return sum;
    }
}
