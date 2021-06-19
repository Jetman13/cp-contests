package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AStrangeFunctions {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.nextLine();
            int len = s.length();
            out.println(len);
        }
    }
}
