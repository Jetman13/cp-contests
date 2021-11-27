package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BStringShifting {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String str = in.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i) + str.substring(0,i));
        }

        list.sort((aa,bb) -> aa.compareTo(bb));
        out.println(list.get(0));
        out.println(list.get(list.size()-1));
    }
}
