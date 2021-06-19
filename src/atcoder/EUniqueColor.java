package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class EUniqueColor {


    Map<Integer, List<Integer>> edges;
    int[] nums;
    List<Integer> ans;
    int[] c;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        c = new int[n];
        in.readArr(c);

        edges = new HashMap<>();

        for (int i = 1; i < n; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            build(a,b);
            build(b,a);
        }

        if (n == 1) {
            out.println(1);
            return ;
        }

        nums = new int[100002];
        ans = new ArrayList<>();
        dfs(0,-1);


        ans.sort(Comparator.naturalOrder());

        for (Integer an : ans) {
            out.print((an+1) + " ");
        }
        out.println();

    }

    private void dfs(int root, int fa) {

        if (nums[c[root]] == 0) {
            ans.add(root);
        }
        nums[c[root]]++;
        List<Integer> list = edges.get(root);
        for (Integer x : list) {
            if (x == fa) continue;
            dfs(x,root);
        }
        nums[c[root]]--;
    }

    private void build(int a, int b) {
        List<Integer> list = edges.getOrDefault(a, new ArrayList<>());
        list.add(b);
        edges.put(a,list);
    }
}
