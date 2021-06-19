package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EWhitePawn {
    class Node {
        long i;
        long j;

        public Node(long index, long m) {
            this.i = index;
            this.j = m;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        int m = in.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long x = in.nextLong();
            long y = in.nextLong();
            if (x == 0) continue;
            list.add(new Node(x,y));
        }


        list.sort((aa,bb) -> {
            if (aa.i > bb.i) return 1;
            else if (aa.i < bb.i) return -1;
            else return 0;
        });

        if (list.size() == 0) {
            out.println(1);
            return ;
        }

        Set<Long> set = new HashSet<>();
        set.add(n);
        Set<Long> addSet = new HashSet<>();
        Set<Long> delSet = new HashSet<>();
        long s = list.get(0).i;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).i == s) {
                long x = list.get(i).j;
                if (set.contains(x-1) || set.contains(x+1)) {
                    addSet.add(x);
                } else if (set.contains(x)) {
                    delSet.add(x);
                }

            } else {
                s = list.get(i).i;
                i--;
                for (Long key : delSet) {
                    set.remove(key);
                }
                for (Long key : addSet) {
                    set.add(key);
                }
                delSet.clear();
                addSet.clear();
            }
        }

        for (Long key : delSet) {
            set.remove(key);
        }
        for (Long key : addSet) {
            set.add(key);
        }

        out.println(set.size());


    }
}
