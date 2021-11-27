package atcoder;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EAmusementPark {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long k = in.nextLong();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextLong());
        }
        list.add(0L);

        list.sort(Collections.reverseOrder());


        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (list.get(i).equals(list.get(i+1))) {
                i++;
            }
            long num = i+1;
            if (num*(list.get(i) - list.get(i+1)) <= k) {
                k-=num*(list.get(i) - list.get(i+1));
                ans += (((list.get(i) - list.get(i+1))*(list.get(i) + list.get(i+1)+1))/2)*num;
            } else {
                long tmp = k/num;
                k-=tmp*num;
                ans += ((tmp*(list.get(i) + list.get(i)-tmp+1))/2)*num;

                ans += k*(list.get(i)-tmp);
                k = 0;

            }
            if (k == 0) break;
        }
        out.println(ans);
    }
}
