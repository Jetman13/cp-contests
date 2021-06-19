package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class HamsterAndEquation {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int MAX = 2001*2001*2 + 20;
            int[] num = new int[MAX];
            for (int i = -n; i <=n ; i++) {
                for (int j = -n; j <= n; j++) {
                    int tmp = i*(i+1) + j*(j+1);
                    num[tmp]++;
                }
            }

            int ans = 0;
            for (int i = 0; i < MAX; i++) {
                if (i*k >= MAX || i*k < 0) continue;
                ans += num[i] * (num[i*k]);
            }

            out.println(ans);
        }
    }

    private int checkAns(int tmp,int n) {
        double dou = Math.sqrt(tmp);

        int douint = (int)(dou+0.0001);
        if (douint*douint == tmp) {
            if (douint == 0) return 0;
            int ans = 0;
            if ((douint-1)%2==0 && (douint-1)/2 >= -n && (douint-1)/2 <= n) ans++;
            if ((-douint-1)%2==0 && (-douint-1)/2 >= -n && (-douint-1)/2 <= n) ans++;
            return ans;
        }
        return 0;
    }
}
