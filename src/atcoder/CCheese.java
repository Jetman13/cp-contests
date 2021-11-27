package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CCheese {
    class Node {
        long a;
        long b;

        public Node(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long w = in.nextInt();

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(in.nextLong(),in.nextLong()));
        }

        list.sort((aa,bb)->{
            if (aa.a < bb.a) return 1;
            else if (aa.a > bb.a) return -1;
            else return 0;
        });

        long ans = 0;

        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            if (node.b <= w) {
                w-=node.b;
                ans += node.a*node.b;
            } else {
                ans += node.a*w;
                w = 0;
                break;
            }
        }

        out.println(ans);

    }
}
