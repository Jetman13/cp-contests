package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class EFourSegments {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int[] a = new int[4];
            in.readArr(a);
            Arrays.sort(a);
            out.println(a[2]*a[0]);
        }
    }
}
