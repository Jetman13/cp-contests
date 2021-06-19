package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            String s = in.nextLine();
            char[] chs = s.toCharArray();
            String max = s;
            for (int i = 0; i < chs.length; i++) {
                for (int j = 0; j < chs.length; j++) {
                    char ch = chs[i];
                    chs[i] = chs[j];
                    chs[j] = ch;
                    if (max.compareTo(toStr(chs)) < 0) {
                        max = toStr(chs);
                    }
                    ch = chs[i];
                    chs[i] = chs[j];
                    chs[j] = ch;
                }
            }
            out.println(max);

        }
    }

    private String toStr(char[] chs) {
        String s = new String(chs);
        return s;
    }
}
