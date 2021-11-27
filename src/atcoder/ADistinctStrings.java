package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class ADistinctStrings {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();
        Set<String> set = new HashSet<>();
        set.add(s);
        set.add(s.charAt(0) +""+ s.charAt(2) +""+ s.charAt(1));
        set.add(s.charAt(1) +""+ s.charAt(0) +""+ s.charAt(2));
        set.add(s.charAt(1) +""+ s.charAt(2) +""+ s.charAt(0));
        set.add(s.charAt(2) +""+ s.charAt(0) +""+ s.charAt(1));
        set.add(s.charAt(2) +""+ s.charAt(1) +""+ s.charAt(0));
        out.println(set.size());
    }
}
