package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class GGamerGirlGauntlet {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long s = in.nextLong();
        long[] d = new long[n];
        long[] r = new long[n];
        Arrays.setAll(d,i->in.nextLong());
        Arrays.setAll(r,i->in.nextLong());

        Queue<Long> q = new PriorityQueue<>((a,b)->{
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            }
            return 0;
        });

        boolean win = true;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (s >= d[i]) {
                q.offer(r[i]);
                s-=d[i];
            } else {
                while (!q.isEmpty() && s < d[i]) {
                    s += q.poll();
                }
                if (s < d[i]) {
                    win = false;
                    num = i;
                    break;
                }
                q.offer(r[i]);
                s-=d[i];
            }
        }
        out.println(win?"WIN":"LOSE");
        out.println(win?(n-q.size()) : (num));


    }
}
