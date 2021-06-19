package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class E1ThreeBlocksPalindromeEasyVersion {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            int[][] num = new int[27][n+1];
            for (int i = 0; i < 26; i++) {
                for (int j = 1; j <= n; j++) {
                    num[i][j] = num[i][j-1] + (a[j-1] == (i+1) ? 1 : 0);
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int sum = 0;
                    for (int k = 0; k < 26; k++) {
                        int min = Math.min(num[k][i],num[k][n] - num[k][j+1]);
                        sum = Math.max(min*2,sum);
                    }
                    for (int k = 0; k < 26; k++) {
                        ans = Math.max(sum + num[k][j+1] - num[k][i],ans);
                    }
                }
            }
            out.println(ans);


        }
    }
}
