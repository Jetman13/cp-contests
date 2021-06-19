package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class KTheRobot {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        out.println(in.nextLine().replace('5','*'));
    }

    private boolean check(String tmp, int blocki, int blockj) {
        int len = tmp.length();
        int si = 0;
        int sj = 0;
        for (int i = 0; i < len; i++) {
            char ch = tmp.charAt(i);
            if (ch == 'U' && (si!=blocki || (sj+1)!=blockj)) {
                sj++;
            } else if (ch == 'D'&& (si!=blocki || (sj-1)!=blockj)) {
                sj--;
            } else if (ch == 'L'&& ((si-1)!=blocki || (sj)!=blockj)) {
                si--;
            } else if (ch == 'R' && ((si+1)!=blocki || (sj)!=blockj)){
                si++;
            }
        }
        return si == 0 && sj == 0;
    }

    private int[][] getPath(String tmp) {
        int len = tmp.length();
        int si = 0;
        int sj = 0;
        int[][] path = new int[len+1][2];
        for (int i = 0; i < len; i++) {
            char ch = tmp.charAt(i);
            if (ch == 'U') {
                sj++;
            } else if (ch == 'D') {
                sj--;
            } else if (ch == 'L') {
                si--;
            } else {
                si++;
            }
            path[i+1][0] = si;
            path[i+1][1] = sj;
        }
        return path;
    }
}
