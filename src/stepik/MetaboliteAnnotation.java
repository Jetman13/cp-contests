package stepik;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetaboliteAnnotation {
    class Node {
        double val;
        int mi;
        int ki;

        public Node(double val, int mi, int ki) {
            this.val = val;
            this.mi = mi;
            this.ki = ki;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- >0) {
            int m = in.nextInt();
            int k = in.nextInt();
            int n = in.nextInt();
            double[] mval = new double[m];
            double[] kval = new double[k];
            double[] nval = new double[n];
            in.readArr(mval);
            in.readArr(kval);
            in.readArr(nval);

            List<Node> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < k; j++) {
                    double val = mval[i] + kval[j];
                    if (val > 0) {
                        list.add(new Node(val,i+1,j+1));
                    }
                }
            }

            list.sort((aa, bb) -> {
                if (aa.val > bb.val) return 1;
                else if (aa.val < bb.val) return -1;
                else return 0;
            });

            for (int i = 0; i < n; i++) {
                Node node = getNode(list,nval[i]);
                out.println(node.mi + " " + node.ki);
            }
            
            

        }
    }

    private Node getNode(List<Node> list, double v) {
        double abs = 100000000.0;
        int i = 0,j = 0;
        int l = 0;
        int r = list.size()-1;
        while (l <= r) {
            int mid = (l+r)/2;
            Node node = list.get(mid);
            if (Math.abs(node.val-v) < abs) {
                i = node.mi;
                j = node.ki;
                abs = Math.abs(node.val-v);
            }
            if (node.val > v) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new Node(abs,i,j);
    }
}
