package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CDoubled {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long n = in.nextLong();

        int index = 0;
        for (long i = 1; i < 1000000; i++) {
            if (Long.parseLong(i+""+i) <= n) index++;
        }

        out.println(index);
    }
}
