package atcoder;

import tool.FastReader;
import tool.Permutation;
import tool.RangeTree;

import java.io.PrintWriter;

public class DWaterHeater {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        long w = in.nextLong();
        RangeTree rt = new RangeTree(200001);

        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int t = in.nextInt();
            long p = in.nextLong();
            rt.update(s,t-1,p);
        }

        long max = rt.maxQuery(0,200000);
        if (max > w) {
            out.println("No");
        } else {
            out.println("Yes");
        }

    }
}
