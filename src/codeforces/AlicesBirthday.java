package codeforces;

import java.util.ArrayList;
import java.util.List;

public class AlicesBirthday {
    public int[] partition(int k) {
        int[] f = new int[41];
        f[1] = 1;
        f[2] = 1;
        if (k == 1) return new int[]{-1};
        if (k == 2) return new int[]{1};
        int sum = 2;
        for (int i = 3; i <= k; i++) {
            f[i] = f[i-1] + f[i-2];
            sum+=f[i];
        }
        if (sum%2 != 0) return new int[]{-1};

        int[] ans = new int[k/3 + (k%3!=0?1:0)];
        int index = 0;
        for (int i = k; i >= 1; i-=3) {
            ans[index++] = i;
        }
        if (index < ans.length) ans[index] = 1;
        return ans;
    }
}
