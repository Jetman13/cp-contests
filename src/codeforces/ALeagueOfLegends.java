package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ALeagueOfLegends {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long blue = 0;
        for (int i = 0; i < 5; i++) {
            blue += in.nextLong();
        }
        long red = 0;
        for (int i = 0; i < 5; i++) {
            red += in.nextLong();
        }

        out.println(blue >= red ? "Blue":"Red");
    }
}
