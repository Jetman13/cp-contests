package codeforces;

import tool.FastReader;
import tool.FenwichTree;
import tool.RangeTree;

import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FATMAndStudents {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long s = in.nextLong();
            long[] a = new long[n];
            in.readArr(a);

            int l = 1;
            int r = n;
            boolean f = false;
            int ansl = 0,ansr = 0;
            while (l <= r) {
                int mid = (l+r)/2;
                int start = check(mid,a,s);
                if (start >= 0) {
                    l = mid + 1;
                    f = true;
                    ansl = start + 1;
                    ansr = mid + start;
                } else {
                    r = mid - 1;
                }
            }
            if (f) {
                out.println(ansl + " " + ansr);
            } else {
                out.println(-1);
            }
        }
    }

    class Node {
        int index;
        long val;

        public Node(int index, long val) {
            this.index = index;
            this.val = val;
        }
    }
    private int check(int mid, long[] a, long s) {
        int n = a.length;
        long[] sum = new long[n];
        long p = 0;
        for (int i = 0; i < n; i++) {
            sum[i] = p + a[i];
            p = sum[i];
        }
        Deque<Node> q = new LinkedList<>();

        for (int i = 0; i < mid; i++) {
            while (!q.isEmpty() && q.getLast().val >= sum[i]) {
                q.pollLast();
            }
            q.offerLast(new Node(i,sum[i]));
        }


        int index = 0;
        long preSum = 0;
        while (index + mid - 1 < n) {
            long min = q.getFirst().val - preSum;
            if (s + min >= 0) {
                return index;
            }
            while (!q.isEmpty() && q.getFirst().index <= index) {
                q.pollFirst();
            }

            index++;
            if (index + mid - 1 >= n) break;

            while (!q.isEmpty() && q.getLast().val >= sum[index-1+mid]) {
                q.pollLast();
            }
            q.offerLast(new Node(index+mid,sum[index-1+mid]));



            preSum = sum[index-1];
            //rt.update(index,index + mid - 1,-rt.sumQuery(index-1,index-1));
        }
        return -1;

    }
}
