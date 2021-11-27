package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class DPairOfBalls {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer>[] buck = new ArrayList[m];
        int[] index = new int[m];
        Arrays.setAll(buck,i->new ArrayList<>());
        List<Integer>[] flag = new ArrayList[n+1];
        Arrays.setAll(flag,i -> new ArrayList<>());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                buck[i].add(in.nextInt());
            }
            flag[buck[i].get(0)].add(i);
            if (flag[buck[i].get(0)].size() > 1) {
                q.offer(buck[i].get(0));
            }
        }

        int num = 0;

        while (!q.isEmpty()) {
            Integer val = q.poll();
            int l = flag[val].get(0);
            int r = flag[val].get(1);

            num++;

            index[l]++;
            index[r]++;

            if (index[l] < buck[l].size()) {
                flag[buck[l].get(index[l])].add(l);
                if (flag[buck[l].get(index[l])].size() > 1) {
                    q.offer(buck[l].get(index[l]));
                }
            }

            if (index[r] < buck[r].size()) {
                flag[buck[r].get(index[r])].add(r);
                if (flag[buck[r].get(index[r])].size() > 1) {
                    q.offer(buck[r].get(index[r]));
                }
            }

        }

        out.println(num == n ? "Yes" : "No");




    }
}
