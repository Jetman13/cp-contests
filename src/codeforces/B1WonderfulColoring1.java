package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class B1WonderfulColoring1 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            String s = in.nextLine();
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i)-'a']++;
            }

            Arrays.sort(num);

            int one = 0;
            int moveOne = 0;
            for (int i = 0; i < num.length; i++) {
                if (num[i] == 1) one++;
                else if (num[i] > 1) moveOne++;
            }

            out.println(moveOne + (one/2));


        }
    }
}
