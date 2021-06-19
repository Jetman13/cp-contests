package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TaskA {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        countSubgraphsForEachDiameter(2,new int[][]{{1,2}});

    }
    List<Integer>[] edge;
    int n;
    int rootNum;
    int maxH;
    public int[] countSubgraphsForEachDiameter(int nn, int[][] edges) {

        n = nn;
        edge = new ArrayList[n];
        for (int i=0;i<n;i++) {
            edge[i] = new ArrayList<>();
        }
        int[] ans = new int[n-1];
        for (int i = 0; i < edges.length; i++) {
            edge[edges[i][0]-1].add(edges[i][1]-1);
            edge[edges[i][1]-1].add(edges[i][0]-1);
        }
        int num = 1<<n;
        for (int i = 1; i < num; i++) {
            int k = -1;
            for (int j = 0; j < n; j++) {
                if (((1<<j)&i) > 0) {
                    k = j;
                    break;
                }
            }
            if (!check(k,i)) {
                continue;
            }
            maxH = -2;
            dfs1(k,0,-1,i);
            int ansNum = dfs1(rootNum,0,-1,i);
            if (ansNum > 0)
                ans[ansNum-1]++;
        }
        return ans;

    }

    private boolean check(int root, int bit) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (((1<<i)&bit) > 0) {
                num++;
            }
        }
        if (dfs(root,-1,bit) < num) {
            return false;
        }

        return true;

    }

    private int dfs(int root,int p,int bit) {
        List<Integer> list = edge[root];
        int num = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != p && ((1<<list.get(i))&bit) > 0) {
                num+=dfs(list.get(i),root,bit);
            }
        }
        return num;
    }

    private int dfs1(int root, int h,int p,int bit) {
        if (h > maxH) {
            maxH = h;
            rootNum = root;
        }
        List<Integer> list = edge[root];
        int ans = 0;
        for (Integer node : list) {
            if (node != p && ((1<<node)&bit) > 0 ) {
                ans = Math.max(ans,dfs1(node, h + 1,root,bit)+1);
            }
        }
        return ans;
    }

}
