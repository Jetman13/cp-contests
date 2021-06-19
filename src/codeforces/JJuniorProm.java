package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class JJuniorProm {
    List<Integer>[] edge ;
    List<Integer>[] group;
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        int m = in.nextInt();
        group = new ArrayList[m+1];
        Map<String,Integer> map = new HashMap<>();
        int index = 1;
        edge = new ArrayList[n+1];
        Arrays.setAll(edge,i->new ArrayList<>());
        boolean fail = false;
        for (int i = 0; i < m; i++) {
            group[i+1] = new ArrayList<>();
            in.nextInt();
            String[] str = in.nextLine().split(" ");
            for (String s : str) {
                Integer num = map.get(s);
                if (num == null) {
                    num = index++;
                    map.put(s,num);
                }
                group[i+1].add(num);
                edge[num].add(i+1);
                if (edge[num].size() > 2) {
                    fail = true;
                }
            }

        }

        if (fail) {
            out.println("NO");
            return ;
        }

        int[] ans = new int[m+1];
        //bfs
        int[] flag = new int[m+1];
        Arrays.fill(flag,-1);
        for (int i = 1; i <= m ; i++) {
            if (flag[i] >= 0) continue;
            List<Integer> llist = new ArrayList<>();
            List<Integer> rlist = new ArrayList<>();

            if (!dfs(flag,-1,0,i,llist,rlist)) {
                out.println("NO");
                return ;
            }

//            int lnum = llist.stream().mapToInt(p->group[p].size()).sum();
//            int rnum = rlist.stream().mapToInt(p->group[p].size()).sum();
            int lnum = llist.size();
            int rnum = rlist.size();
            if (lnum > rnum) {
                for (Integer l : llist) {
                    ans[l] = 1;
                }
                for (Integer r : rlist) {
                    ans[r] = 2;
                }
            } else {
                for (Integer l : llist) {
                    ans[l] = 2;
                }
                for (Integer r : rlist) {
                    ans[r] = 1;
                }
            }

        }

        out.println("YES");
        for (int i = 1; i <= m ; i++) {
            out.println(ans[i] == 1 ? "Saturday":"Sunday");
        }


    }

    private boolean dfs(int[] flag,int fa, int now, int root, List<Integer> llist, List<Integer> rlist) {

        if (flag[root] >= 0 && flag[root] != now) return false;
        if (flag[root] >=0) return true;

        if (now == 0) {
            llist.add(root);
        } else {
            rlist.add(root);
        }
        flag[root] = now;

        for (Integer node : group[root]) {
            for (Integer x : edge[node]) {
                if (fa == x || root == x) continue;
                if (!dfs(flag,root,now^1,x,llist,rlist)) {
                    return false;
                }
            }
        }
        return true;
    }
}
