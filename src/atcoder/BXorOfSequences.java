package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BXorOfSequences {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        in.readArr(a);
        in.readArr(b);

        boolean[] af = new boolean[1003];
        boolean[] bf = new boolean[1003];
        for (int i = 0; i < n; i++) {
            af[a[i]] = true;
        }
        for (int i = 0; i < m; i++) {
            bf[b[i]] = true;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!bf[a[i]]) {
                ans.add(a[i]);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!af[b[i]]) {
                ans.add(b[i]);
            }
        }

        ans.sort(Comparator.naturalOrder());

        for (int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i) + " ");
        }
        out.println();

    }
}
