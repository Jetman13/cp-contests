package codechef;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class TeamName {
    class Node {
        String val;
        String last;
        String pre;

        public Node(String val, String last, String pre) {
            this.val = val;
            this.last = last;
            this.pre = pre;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- >0) {
            int n = in.nextInt();

            String[] tmps = in.nextLine().split(" ");
            Node[] nodes = new Node[n];
            Set<String> set = new HashSet<>();
            Set<String>[] letSet = new HashSet[30];
            List<Node>[] letList = new ArrayList[30];
            Arrays.setAll(letSet,i->new HashSet<String>());
            Arrays.setAll(letList,i->new ArrayList<>());
            for (int i = 0; i < n; i++) {
                String tmp = tmps[i];
                String last = tmp.substring(1);
                nodes[i] = new Node(tmp,last,tmp.substring(0,1));
                letSet[tmp.charAt(0)-'a'].add(last);
                set.add(tmp);
                letList[tmp.charAt(0)-'a'].add(nodes[i]);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                String last = nodes[i].last;
                for (int j = 0; j < 26; j++) {
                    if (letSet[j].contains(last)) continue;

                    for (Node node : letList[j]) {
                        if (!set.contains(nodes[i].pre + node.last) && !set.contains(node.pre + nodes[i].last)) {
                            ans++;
                        }
                    }
                }

            }

            out.println(ans);

        }
    }
}
