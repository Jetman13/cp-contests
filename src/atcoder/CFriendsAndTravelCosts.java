package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CFriendsAndTravelCosts {
    class Node {
        long index;
        long m;

        public Node(long index, long m) {
            this.index = index;
            this.m = m;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long k = in.nextLong();

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(in.nextLong(),in.nextLong()));
        }

        Collections.sort(list,(aa,bb)-> {
            if (aa.index > bb.index) return 1;
            else if (aa.index < bb.index) return -1;
            else {
                if (aa.m > bb.m) return 1;
                else if (aa.m < bb.m) return -1;
                else return 0;
            }
        });

        long max = k;
        int i = 0;
        while (i < n && max >= list.get(i).index) {
            max += list.get(i).m;
            i++;
        }
        out.println(max);

    }
}
