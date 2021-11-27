package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DLongestX {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();
        int k = in.nextInt();

        int[] num = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            num[i+1] = num[i] + (s.charAt(i) == 'X' ? 1 : 0);
        }

        int l = 0;
        int r = s.length();
        int ans = 0;
        while (l <= r) {
            int mid = (l+r)/2;

            if (check(num,mid,k)) {
                ans = Math.max(ans,mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        out.println(ans);
    }

    private boolean check(int[] num, int mid, int k) {
        if (mid == 0) return true;
        for (int i = mid; i < num.length; i++) {
            int tmp = num[i] - num[i-mid];
            if (tmp + k >= mid) return true;
        }
        return false;
    }
}
