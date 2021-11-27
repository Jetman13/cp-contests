package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BTakahashisSecret {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt() - 1;
        }

        boolean[] f = new boolean[n];
        dfs(x-1,f,a);
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (f[i]) num++;
        }
        out.println(num);
    }

    private void dfs(int x, boolean[] f,int[] a) {
        if (f[x]) return;
        f[x] = true;
        dfs(a[x],f,a);
    }
}
