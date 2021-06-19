package google;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PrimeTime {
    List<Integer> plist;
    long ans = 0;
    int sum = 0;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int m = in.nextInt();
        plist = new ArrayList<>();
        sum = 0;
        for (int i = 0; i < m; i++) {
            int p = in.nextInt();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                plist.add(p);
                sum += p;
            }
        }

        int len = plist.size();
        //long ans = 0;
        ans = 0;

        boolean[] f = new boolean[plist.size()];
        for (int i = 0; i < plist.size(); i++) {
            f[i] = true;
            dfs(plist.get(i),plist.get(i),i+1,f);
            f[i] = false;
        }

//        for (int i = 0; i < (1<<len); i++) {
//            //sum
//            long sum = 0;
//            long multi = 1;
//            for (int j = 0; j < len; j++) {
//                if ((i&(1<<j)) > 0) {
//                    sum += plist.get(j);
//                } else {
//                    multi *= plist.get(j);
//                }
//            }
//            if (sum == multi) {
//                ans = Math.max(ans,sum);
//            }
//        }

        out.println("Case #" + testNumber + ": " + ans);
    }

    private void dfs(int mu,int tmpSum, int i,boolean[] f) {

        if (mu > sum - tmpSum) return ;

        if (mu == sum - tmpSum) {
            ans = Math.max(ans,mu);
            return;
        }

        for (int j = i; j < plist.size(); j++) {
            f[j] = true;
            dfs(mu*plist.get(j),tmpSum+plist.get(j),j+1,f);
            f[j] = false;
            dfs(mu,tmpSum,j+1,f);
        }
    }
}
