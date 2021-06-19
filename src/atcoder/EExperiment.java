package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class EExperiment {
    String query = "MIX";
    String answer = "ANSWER";
    class Node {
        int l,r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out1) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            Map<String,Node> map = new HashMap<>();
            System.out.println(query);
            System.out.println(n);
            for (int i = 1; i <= n; i++) {
                System.out.println(i);
            }
            System.out.flush();
            String[] str = in.nextLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                map.put(str[i],new Node(1,n));
            }
            if (n == 1) {
                System.out.println(answer);
                System.out.println(str[0]);
                System.out.flush();
                continue;
            }
            List<Node> list = new ArrayList<>();
            list.add(new Node(1,n));
            for (int i = 0; i < 10; i++) {
                System.out.println(query);
                List<Integer> tmplist = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    int l = list.get(j).l;
                    int mid = (list.get(j).l + list.get(j).r)/2;
                    for (int k = l; k <= mid ; k++) {
                        tmplist.add(k);
                    }
                }
                System.out.println(tmplist.size());
                for (Integer integer : tmplist) {
                    System.out.println(integer);
                }
                System.out.flush();

                str = in.nextLine().split(" ");
                Set<String> set = new HashSet<>();
                for (String s : str) {
                    Node node = map.get(s);
                    node.r = (node.l + node.r)/2;
                    map.put(s,node);
                    set.add(s);
                }

                Iterator<Map.Entry<String, Node>> it = map.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<String, Node> itEntry = it.next();
                    if (!set.contains(itEntry.getKey())) {
                        itEntry.getValue().l = (itEntry.getValue().l + itEntry.getValue().r)/2 + 1;
                    }
                }

                List<Node> tl = new ArrayList<>();
                for (Node node : list) {
                    int mid = (node.l+node.r)/2;
                    tl.add(new Node(node.l,mid));
                    tl.add(new Node(mid+1,node.r));
                }

                list = tl;


            }

            String[] ans = new String[1002];
            Iterator<Map.Entry<String, Node>> it = map.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String, Node> itEntry = it.next();
                ans[itEntry.getValue().l] = itEntry.getKey();
            }
            System.out.println(answer);
            for (int i = 1; i <= n; i++) {
                System.out.println(ans[i]);
            }
            System.out.flush();

        }

    }

    public static void main(String[] args) {
        new EExperiment().solve(1,null,null);
    }
}
