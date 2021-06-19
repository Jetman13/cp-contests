package codeforces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondDiameters {
    class Node {
        int l;
        int r;
        long val;

        public Node(int x, int y, long val) {
            this.l = x;
            this.r = y;
            this.val = val;
        }
    }
    public long getSecondDiameters(int[] X, int[] Y) {

        int len = X.length;
        if (len == 3) return 0;

        Node first = new Node(-1,-1,-1);
        Node sec = new Node(-1,-1,-1);
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                long dis = dis(X[i],Y[i],X[j],Y[j]);
                if (dis > first.val) {
                    sec = first;
                    first = new Node(i,j,dis);
                } else if (dis > sec.val && dis < first.val) {
                    sec = new Node(i,j,dis);
                }
            }
        }



        Set<Integer> set = new HashSet<>();
        set.add(first.l);
        set.add(first.r);
        set.add(sec.l);
        set.add(sec.r);


        int num = set.size();
        long ans = (len - num)*sec.val;

        for (Integer index : set) {
            ans += cal(X,Y,index);
        }

        return ans;
    }

    private long cal(int[] x, int[] y, Integer index) {

        long first = -1;
        long second = -1;
        int len = x.length;
        for (int i = 0; i < len; i++) {
            if (i == index) continue;
            for (int j = 0; j < len; j++) {
                if (j == index) continue;
                long dis = dis(x[i],y[i],x[j],y[j]);
                if (dis > first) {
                    second = first;
                    first = dis;
                } else if (dis > second && dis < first) {
                    second = dis;
                }
            }
        }
        return second;

    }

    private long dis(int x, int y, int a, int b) {
        return (a-x)*(a-x) + (b-y)*(b-y);
    }
}
