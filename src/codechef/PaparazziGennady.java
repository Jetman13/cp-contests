package codechef;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class PaparazziGennady {
    class Node {
        int l;
        double r;

        public Node(int l, double r) {
            this.l = l;
            this.r = r;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            double[] a = new double[n];
            Arrays.setAll(a,i->in.nextDouble());

            Stack<Node> stack = new Stack<>();
            stack.add(new Node(1,a[0]));
            int ans = 0;
            for (int i = 1; i < n; i++) {
                Node node = stack.pop();
                ans = Math.max(ans,i-node.l+1);
                double k = (a[i]-node.r)/(i+1-node.l);
                while (!stack.isEmpty()) {
                    double k1 = (a[i]-stack.peek().r)/(i+1-stack.peek().l);
                    if (k1 < k || Math.abs(k1-k) < 0.000001) {
                        k = k1;
                        node = stack.pop();
                        ans = Math.max(ans,i-node.l+1);
                    } else {
//                        stack.add(node);
                        break;
                    }
                }
                stack.add(node);
                //if (stack.peek().r < a[i]) {
                    stack.add(new Node(i+1,a[i]));
                //}
            }
            out.println(ans);

        }
    }
}
