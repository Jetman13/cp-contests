package codechef;

import tool.FastReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrogSort {
    class Node {
        int l,r,i;

    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0 ) {
            int n = in.nextInt();
            Node[] list = new Node[n];
            for (int i = 0; i < n; i++) {
                list[i] = new Node();
                list[i].i = i+1;
                list[i].l = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                list[i].r = in.nextInt();
            }

            Arrays.sort(list,(a,b) -> a.l - b.l);

            int ans = 0;
            int p = list[0].i;
            int max = p;
            for (int i = 1; i < n; i++) {
                int tmp = p;
                if (list[i].l == list[i-1].l) {
                    tmp = p;
                } else {
                    p = max;
                    tmp = p;
                }

                if (list[i].i > tmp) {
                    max = Math.max(max,list[i].i);
                } else {
                    int k = (tmp - list[i].i)/(list[i].r) + 1;
                    max = Math.max(max,list[i].i + k*list[i].r);
                    ans += k;
                }
            }
            out.println(ans);



        }
    }
}
