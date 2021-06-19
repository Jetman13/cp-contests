package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class DDogeforces {

    class Node {
        int val;
        int x;
        int y;

        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

    }

    int[] fa;
    int fa(int root) {
        return fa[root] == root ? root : (fa[root] = fa(fa[root]));
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        int[][] a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        List<Node> infos = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                infos.add(new Node(a[i][j], i, j));
            }
        }

        List<Node> nodes = new ArrayList<>();
        List<Node> edges = new ArrayList<>();
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(a[i][i], i, 0));
            parent[i] = i;
        }

        infos.sort((aa, bb) -> aa.val - bb.val);


        int r = 0;
        for (int l = 0; l < infos.size(); l = r) {
            r = l;
            while (r < infos.size() && infos.get(r).val == infos.get(l).val) r++;

            List<List<Integer>> llist = heap(infos,l,r,a);
            for (List<Integer> list : llist) {
                Set<Integer> set = new HashSet<>();
                int newP = nodes.size() + 1;
                for (Integer info : list) {
                    set.add(parent[info]);
                }
                for (Integer info : list) {
                    parent[info] = newP;
                }

                for (Integer p : set) {
                    edges.add(new Node(-1, p, newP));
                }
                nodes.add(new Node(infos.get(l).val, newP, 0));
            }
//            Set<Integer> set = new HashSet<>();
//            int newP = nodes.size() + 1;
//            for (int i = l; i < r; i++) {
//                set.add(parent[infos.get(i).x]);
//                set.add(parent[infos.get(i).y]);
//            }
//            for (int i = l; i < r; i++) {
//                parent[infos.get(i).x] = newP;
//                parent[infos.get(i).y] = newP;
//            }
//
//            for (Integer p : set) {
//                edges.add(new Node(-1, p, newP));
//            }
//            nodes.add(new Node(infos.get(l).val, newP, 0));

        }

        if (nodes.size() != edges.size() + 1) {
            out.println("nodes.size=" + nodes.size() + " edges.size = " + edges.size());
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    out.print(a[i][j] + " ");
                }
                out.println();
            }

        }

        out.println(nodes.size());
        for (Node node : nodes) {
            out.print(node.val + " ");
        }
        out.println();
        out.println(nodes.get(nodes.size() - 1).x);
        for (Node edge : edges) {
            out.println(edge.x + " " + edge.y);
        }
    }

    private List<List<Integer>> heap(List<Node> infos, int l, int r, int[][] a) {
        fa = new int[a.length];
        Arrays.setAll(fa,i->i);
        for (int i = l; i < r; i++) {
            int x = infos.get(i).x;
            int y = infos.get(i).y;
            int fax = fa(x);
            int fay = fa(y);
            fa[fax] = fay;
        }

        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = l; i < r; i++) {
            int x = infos.get(i).x;
            int y = infos.get(i).y;
            int fax = fa(x);
            List<Integer> list = map.getOrDefault(fax,new ArrayList<>());
            if (!list.contains(x)) list.add(x);
            if (!list.contains(y)) list.add(y);
            map.put(fax,list);
        }
        List<List<Integer>> llist = new ArrayList<>();
        map.forEach((k,v) -> {
            llist.add(v);
        });
        return llist;

    }
}
