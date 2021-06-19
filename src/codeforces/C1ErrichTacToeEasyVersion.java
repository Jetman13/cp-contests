package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class C1ErrichTacToeEasyVersion {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            char[][] ch = new char[n][n];
            int token = 0;
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                ch[i] = s.toCharArray();
                for (int j = 0; j < ch[i].length; j++) {
                    if (ch[i][j] != '.') token++;
                }
            }

            int[][] a = new int[][]{{2,1,0},{0,2,1},{1,0,2}};
            char[][] chtmp = null;
            for (int k = 0; k < 3; k++) {
                chtmp = copy(ch);
                int change = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = a[k][i%3]; j < n; j+=3) {
                        if (chtmp[i][j] == '.') continue;
                        if (check(i,j,chtmp)) {
                            chtmp[i][j] = 'O';
                            change++;
                        }
                    }
                }
                if (change <= token/3) {
                    ch = copy(chtmp);
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(ch[i][j]);
                }
                out.println();
            }

        }
    }

    private char[][] copy(char[][] ch) {
        char[][] tmp = new char[ch.length][ch.length];
        for (int i = 0; i < ch.length; i++) {
            tmp[i] = Arrays.copyOf(ch[i],ch[i].length);
        }
        return tmp;
    }

    private boolean check(int i, int j, char[][] ch) {
        //up
        int n = ch.length;

        int l = i;
        while (l >= 0 && ch[l][j] == 'X') {
            l--;
        }
        int r = i;
        while (r < n && ch[r][j] == 'X') {
            r++;
        }
        if (r-l >= 2) return true;

        l = j;
        while (l >= 0 && ch[i][l] == 'X') {
            l--;
        }
        r = j;
        while (r < n && ch[i][r] == 'X') {
            r++;
        }
        return r-l >= 2;
    }
}
