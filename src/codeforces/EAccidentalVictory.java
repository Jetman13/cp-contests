package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EAccidentalVictory {
    class Node {
        int index;
        long val;

        public Node(int index, long val) {
            this.index = index;
            this.val = val;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            in.readArr(a);
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i+1,a[i]);
            }

            Arrays.sort(nodes,(aa,bb)->{
                if (aa.val == bb.val ) return 0;
                else if (aa.val > bb.val) {
                    return 1;
                } else {
                    return -1;
                }
            });

            long sum = 0;
            int p = 0;
            for (int i = 0; i < n-1; i++) {
                sum += nodes[i].val;
                if (sum < nodes[i+1].val) {
                    p = i+1;
                }
            }
            List<Node> list = new ArrayList<>();
            for (int i = p; i < n; i++) {
                list.add(nodes[i]);
            }

            Collections.sort(list,(aa,bb)-> {
                return aa.index - bb.index;
            });
            out.println(list.size());
            for (Node node : list) {
                out.print(node.index + " ");
            }
            out.println();


        }
    }
}
