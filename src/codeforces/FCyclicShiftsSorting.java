package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FCyclicShiftsSorting {
    boolean inv;
    int[] invIndex = new int[2];
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            inv = false;
            int num = getInvNum(a);
            if (num == 0) {
                out.println(0);
                out.println();
                continue;
            }
//            if (num%2==1 && !inv) {
//                out.println(-1);
//                continue;
//            }
            if (num%2 == 1 && inv) {
                int tmp = a[invIndex[0]];
                a[invIndex[0]] = a[invIndex[1]];
                a[invIndex[1]] = tmp;
            }

            List<Integer> ans = calAns(a);
            if (ans == null) {
                out.println(-1);
                continue;
            }
            out.println(ans.size());
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

        }
    }

    private List<Integer> calAns(int[] a) {
        List<Integer> ans = new ArrayList<>();
        int len = a.length;
        for (int i = 0; i < len-2; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i; j < len; j++) {
                if (a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            while (index - 2 >= i) {
                ans.add(index-1);
                move(index-2,a);
                index-=2;
            }
            if (index > i) {
                if (index >= len-1) {
                    return null;
                }
                move(index-1,a);
                move(index-1,a);
                ans.add(index);
                ans.add(index);
            }
        }
        if (!isSort(a)) {
            for (int i = 0; i < 3; i++) {
                if (isSort(a)) break;
                move(len-3,a);
                ans.add(len-2);
            }
        }
        if (!isSort(a)) return null;

        return ans;
    }

    private boolean isSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) return false;
        }
        return true;
    }

    private void move(int index, int[] a) {
        int tmp2 = a[index+2];
        int tmp1 = a[index+1];
        a[index+2] = tmp1;
        a[index+1] = a[index];
        a[index] = tmp2;
    }

    private int getInvNum(int[] a) {
        int len = a.length;
        int[] flag = new int[502];

        int index = -1;
        for (int i = 0; i < len; i++) {
            int tmp = a[i];
            a[i] = a[i]*500 + flag[a[i]];
            flag[tmp]++;
            if (flag[tmp] > 1) {
                index = i;
            }
        }

        int l = -1;
        int r = -1;
        if (index != -1) {
            for (int i = len - 1; i >= 0; i--) {
                if (a[i] / 500 == a[index] / 500) {
                    if (r == -1) {
                        r = i;
                    } else if (l == -1) {
                        l = i;
                    }
                }
            }
            inv = true;
            invIndex[0] = l;
            invIndex[1] = r;
        }


        int num = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (a[i] > a[j]) {
                    num++;
                }
            }
        }
        return num;
    }
}
