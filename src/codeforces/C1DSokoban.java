package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class C1DSokoban {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            in.readArr(a);
            in.readArr(b);

            List<Integer> lista = new ArrayList<>();
            List<Integer> listb = new ArrayList<>();
            for (int i = n-1; i >= 0 && a[i] > 0; i--) {
                lista.add(a[i]);
            }
            for (int i = m-1; i >= 0 && b[i] > 0 ; i--) {
                listb.add(b[i]);
            }
            Collections.reverse(lista);
            Collections.reverse(listb);

            int ans = work(lista,listb);

            lista.clear();
            listb.clear();
            for (int i = 0; i < n && a[i] < 0; i++) {
                lista.add(-a[i]);
            }
            for (int i = 0; i < m && b[i] < 0 ; i++) {
                listb.add(-b[i]);
            }
            Collections.reverse(lista);
            Collections.reverse(listb);

            ans += work(lista,listb);
            out.println(ans);

        }
    }

    private int work(List<Integer> lista, List<Integer> listb) {

        if (lista.isEmpty() || listb.isEmpty()) return 0;

        int[] sum = new int[listb.size()+1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < lista.size(); i++) {
            set.add(lista.get(i));
        }
        for (int i = 0; i < listb.size(); i++) {
            sum[i+1] = sum[i] + (set.contains(listb.get(i)) ? 1 : 0);
        }

        int ans = 0;
        for (int i = 0; i < listb.size(); i++) {
            int a = listb.get(i);
            int l = 0;
            int r = lista.size()-1;
            int maxr = 0;
            while (l <= r) {
                int mid = (l+r)/2;
                if (a + mid < lista.get(mid)) {
                    r = mid - 1;
                } else {
                    maxr = Math.max(a+mid,maxr);
                    l = mid + 1;
                }
            }

            ans = Math.max(ans,cal(a,maxr,listb,sum));

        }
        return ans;

    }

    private int cal(int l, int r, List<Integer> listb, int[] sum) {
        int lkey = Collections.binarySearch(listb,l);
        int rkey = Collections.binarySearch(listb,r);

        if (lkey < 0) {
            lkey = -lkey - 1;
        }
        if (rkey < 0) {
            rkey = -rkey - 2;
        }
        return rkey - lkey + 1 + (sum[listb.size()] - sum[rkey+1]);
    }
}
