package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class DAntiSudoku {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            char[][] sudo = new char[9][9];
            for (int i = 0; i < 9; i++) {
                String ch = in.nextLine();
                for (int j = 0; j < 9; j++) {
                    sudo[i][j] = ch.charAt(j);
                }
            }

            int[][] dir = {{0,0},{1,3},{2,6},{3,1},{4,4},{5,7},{6,2},{7,5},{8,8}};
            for (int k = 0; k < dir.length; k++) {
                int row = dir[k][0];
                int col = dir[k][1];
                boolean f = false;
                for (int i = 0; i < 9; i++) {
                    if (i == row) continue;
                    if (sudo[row][col] != sudo[i][col]) {
                        sudo[row][col] = sudo[i][col];
                        f = true;
                        break;
                    }
                }
                if (!f) {
                    for (int i = 0; i < 9; i++) {
                        if (i == col) continue;
                        if (sudo[row][col] != sudo[row][i]) {
                            sudo[row][col] = sudo[row][i];
                        }
                    }
                }
            }


            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    out.print(sudo[i][j]);
                }
                out.println();
            }

        }
    }
}
