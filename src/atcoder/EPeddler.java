package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class EPeddler {
    class Node {
        int index;
        long min;

        public Node(int index, long min) {
            this.index = index;
            this.min = min;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] a = new long[n];
        Arrays.setAll(a,i->in.nextLong());
        int[] inNum = new int[n];
        List<Integer>[] edge = new ArrayList[n];
        Arrays.setAll(edge,i->new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int l = in.nextInt()-1;
            int r = in.nextInt()-1;
            edge[l].add(r);
            inNum[r]++;
        }

        //bfs
        Queue<Node> q = new LinkedList<>();
        long[] nmin = new long[n];
        for (int i = 0; i < n; i++) {
            if (inNum[i] == 0) {
                q.offer(new Node(i,a[i]));
            }
            nmin[i] = a[i];
        }
        long ans = Long.MIN_VALUE;
        while (!q.isEmpty()) {
            Node node = q.poll();
            //del
            for (Integer next : edge[node.index]) {
                nmin[next] = Math.min(nmin[node.index],nmin[next]);
                inNum[next]--;
                ans = Math.max(ans,a[next]-nmin[node.index]);
                if (inNum[next] == 0) {
                    q.offer(new Node(next,nmin[next]));
                }
            }
        }
        out.println(ans);

    }
}
