package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChristmasBatteries {
    int[] index = new int[5];
    public int mostFun(int B, int N, int X, int Y, int Z, int M) {

        List<Integer>[] arrlist = new ArrayList[6];
        Arrays.setAll(arrlist,i->new ArrayList<>());

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int val = ((((X*i)%M)*i)%M + (Y*i)%M + Z)%M;
            arrlist[i%5].add(val);
            if (i%5==0) {
                ans += val;
            }
        }

        for (int i = 1; i < 5; i++) {
            Collections.sort(arrlist[i],(a,b)->b-a);
        }

        ans += cal(arrlist,B);


        return ans;
    }

    private int cal(List<Integer>[] arrlist, int b) {
        if (b <= 0) return 0;

        int max = 0;
        for (int i = 1; i < 5; i++) {
            if (b < i) continue;
            if (index[i] >= arrlist[i].size()) continue;
            int tmp = arrlist[i].get(index[i]);
            index[i]++;
            tmp +=cal(arrlist,b-i);
            index[i]--;
            max = Math.max(max,tmp);
        }
        return max;

    }
}
