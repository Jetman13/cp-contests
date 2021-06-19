package codeforces;

import tool.FastReader;
import tool.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BAlmostRectangle {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            char[][] chs = new char[n][n];
            List<Pair<Integer,Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                for (int j = 0; j < n; j++) {
                    chs[i][j] = s.charAt(j);
                    if (chs[i][j] == '*') {
                        list.add(new Pair<>(i,j));
                    }
                }
            }

            if (list.get(0).getKey().equals(list.get(1).getKey())) {
                int x = (list.get(0).getKey() + 1)%n;
                chs[x][list.get(0).getValue()] = '*';
                chs[x][list.get(1).getValue()] = '*';
            } else if (list.get(0).getValue().equals(list.get(1).getValue())) {
                int y = (list.get(0).getValue() + 1)%n;
                chs[list.get(0).getKey()][y] = '*';
                chs[list.get(1).getKey()][y] = '*';
            } else {
                chs[list.get(0).getKey()][list.get(1).getValue()] = '*';
                chs[list.get(1).getKey()][list.get(0).getValue()] = '*';
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(chs[i][j]);
                }
                out.println();
            }

        }
    }
}
