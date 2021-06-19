package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class FFolklore {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.nextLine();
        if (k > n/2) {
            out.println("NO");
            return ;
        }

        String[] songs = str.split(" ");
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            ans[(i+k)%n] = songs[i];
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
    }
}
