package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class IImplementationProblem {
    char[][] map;
    int[][] hole;
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int row = in.nextInt();
        int col = in.nextInt();
        map = new char[row+2][col+2];
        hole = new int[row+2][col+2];
        for (int i = 0; i < row+2; i++) {
            map[i][0] = map[i][col+1] = '#';
            hole[i][0] = hole[i][col+1] = -1;
        }
        for (int i = 0; i < col+2; i++) {
            map[0][i] = map[row+1][i] = '#';
            hole[0][i] = hole[row+1][i] = -1;
        }
        for (int i = 1; i <= row; i++) {
            String str = in.nextLine();
            for (int j = 1; j <= col; j++) {
                hole[i][j] = -1;
                if (str.charAt(j-1) >= '1' && str.charAt(j-1) <= '9') {
                    hole[i][j] = str.charAt(j-1) - '0';
                    map[i][j] = '.';
                } else {
                    map[i][j] = str.charAt(j - 1);
                }
            }
        }

        String path = in.nextLine();

        int[] num = new int[300];
        num['S'] = 0;
        num['W'] = 3;
        num['N'] = 2;
        num['E'] = 1;

        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            for (int j = 0; j < num[dir]; j++) {
                rotate();
            }

            work();

            for (int j = 0; j < (4-num[dir])%4; j++) {
                rotate();
            }
        }

        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= col; j++) {
                if (map[i][j] == '.') {
                    if (hole[i][j] != -1) out.print(hole[i][j]);
                    else
                    out.print('.');
                } else {
                    out.print(map[i][j]);
                }
            }
            out.println();
        }

    }

    private void work() {
        int row = map.length-2;
        int col = map[0].length-2;

        for (int i = 1; i <= col; i++) {
            for (int j = row; j >=1 ; j--) {
                char ch = map[j][i];
                if (ch < 'A' || ch > 'Z') {
                    continue;
                }
                int idx = j+1;
                while (map[idx][i] == '.') {
                    if (hole[idx][i] > 0) {
                        hole[idx][i]--;
                        map[idx-1][i] = '.';
                        break;
                    }
                    map[idx][i] = map[idx-1][i];
                    map[idx-1][i] = '.';
                    idx++;
                }
            }
        }

    }

    private void rotate() {
        int row = map.length-2;
        int col = map[0].length-2;
        char[][] newMap = new char[col+2][row+2];
        int[][] newHole = new int[col+2][row+2];
        for (int i = 0; i <= row+1 ; i++) {
            for (int j = 0; j <= col+1 ; j++) {
                newMap[j][i] = map[i][j];
                newHole[j][i] = hole[i][j];
            }
        }

        map = new char[col+2][row+2];
        hole = new int[col+2][row+2];
        for (int i = 0; i <= col+1; i++) {
            for (int j = 0; j <= row+1; j++) {
                map[i][j] = newMap[i][row+1-j];
                hole[i][j] = newHole[i][row+1-j];
            }
        }

    }
}
