package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AAvoidTrygub {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.nextLine();

            if (s.contains("r")) {
                out.println(replace(s,"r"));
            } else if (s.contains("y")) {
                out.println(replace(s,"y"));
            } else if (s.contains("g")) {
                out.println(replace(s,"g"));
            } else if (s.contains("u")) {
                out.println(replace(s,"u"));
            } else if (s.contains("b")) {
                out.println(replace(s, "b"));
            } else {
                out.println(s);
            }

            
        }
    }

    private String replace(String s, String r) {
        int num = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == r.charAt(0)) {
                num++;
                tmp.append(r);
            }
        }
        return tmp.toString() + s.replace(r,"");
    }
}
