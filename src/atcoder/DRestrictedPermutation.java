package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class DRestrictedPermutation {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Set<String> set = new HashSet<>();
        List<Integer>[] edge = new ArrayList[n+1];
        Arrays.setAll(edge,i->new ArrayList<>());
        int[] inNum = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            String str = a + " " + b;
            if (set.contains(str)) continue;
            set.add(str);
            edge[a].add(b);
            inNum[b]++;
        }

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (inNum[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] flag = new boolean[n+1];
        List<Integer> ans = new ArrayList<>();
        done :
        while (!q.isEmpty()) {
            int to = q.poll();
            ans.add(to);
            //del
            flag[to] = true;
            for (Integer next : edge[to]) {
                inNum[next]--;
                if (flag[next]) {
                    break done;
                }
                if (inNum[next] == 0)
                q.offer(next);
            }
        }
        if (ans.size() < n) {
            out.println("-1");
        } else {
            for (int i = 0; i < n; i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();
        }

    }
}
