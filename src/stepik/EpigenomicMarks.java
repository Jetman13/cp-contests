package stepik;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class EpigenomicMarks {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int m = in.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = in.nextLine();
            }

            String[] tstrs = new String[m];
            for (int i = 0; i < m; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(strs[j].charAt(i));
                }
                tstrs[i] = sb.toString();
            }

            Map<String,Integer> map = new HashMap<>();
            int[] ans = new int[m];
            int p = 1;
            for (int i = 0; i < m; i++) {
                Integer tmp = map.get(tstrs[i]);
                if (tmp == null) {
                    tmp = p++;
                    map.put(tstrs[i],tmp);
                }
                ans[i] = tmp;
            }
            out.println(p-1);
            for (int i = 0; i < m; i++) {
                if (i == m-1) {
                    out.println(ans[i]);
                } else {
                    out.print(ans[i] + " ");
                }
            }

        }
    }
}
