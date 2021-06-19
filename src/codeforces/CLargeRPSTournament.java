package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CLargeRPSTournament {
    char[][] dp = new char[101][101];
    String s;
    int len;
    int[] pow = new int[102];
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        s = in.nextLine();
        len = s.length();

        pow[0] = 1;
        for (int i = 1; i <= k; i++) {
            pow[i] = (pow[i-1]*2)%len;
        }

        out.println(work(0,k));

    }

    private char work(int n, int k) {
        if (dp[n][k] != 0) {
            return dp[n][k];
        }
        if (k == 0) {
            return s.charAt(n);
        }
        char l = work(n,k-1);
        char r = work((n+pow[k-1])%len,k-1);
        char win = win(l,r);
        return dp[n][k] = win;
    }

    private char win(char l, char r) {
        if (l == 'R' && r == 'S') return l;
        if (l == 'P' && r == 'R') return l;
        if (l == 'S' && r == 'P') return l;
        return r;
    }
}
