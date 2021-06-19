package google;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class ClosestPick {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        double ans = 0;
        List<Integer> list = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int c = in.nextInt();
            if (set.contains(c)) {
                continue;
            }
            list.add(c);
            set.add(c);
        }

        list.sort(Comparator.naturalOrder());

        int size = list.size();
        double max = 0;
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (i == j) {
                    if (i == 0) {
                        max = Math.max(max,list.get(0)-1);
                    } else if (i == size) {
                        max = Math.max(max,k - list.get(size-1));
                    } else {
                        max = Math.max(max,(list.get(i) - list.get(i-1) - 1));
                    }
                } else {
                    double tmp = 0;
                    if (i == 0) {
                        tmp = list.get(0)-1;
                    } else if (i == size) {
                        tmp = k - list.get(size-1);
                    } else {
                        tmp = (list.get(i) - list.get(i-1))/2;
                    }

                    if (j == 0) {
                        tmp += list.get(0)-1;
                    } else if (j == size) {
                        tmp += k - list.get(size-1);
                    } else {
                        tmp += (list.get(j) - list.get(j-1))/2;
                    }

                    max = Math.max(max,tmp);

                }
            }
        }


        out.println("Case #" + testNumber + ": " + max/k);
        
    }

    private double cal(int[] a,int k, int i, int j) {
        double ans = 0;
        double win = 0;
        for (int l = 1; l <= k; l++) {
            int lv = Math.min(Math.abs(l-i),Math.abs(l-j));
            int rv = Math.min(getl(a,l),getr(a,l));
            if (lv < rv) win++;
        }
        return win/k;
    }

    private int getr(int[] a, int l) {
        int val = a.length+2;
        int index = l;
        while (index < a.length && a[index] != 1) {
            index++;
        }
        return index == a.length ? val : index - l;
    }

    private int getl(int[] a, int l) {
        int val = a.length+2;
        int index = l;
        while (index >= 0 && a[index] != 1) {
            index--;
        }
        return index == -1 ? val : l - index;
    }
}
