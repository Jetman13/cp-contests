package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FPrefixesAndSuffixes {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int len = (n-1)*2;
        String[] str = new String[len];
        String[] rev = new String[len];
        int[][] index = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(index[i],-1);
        }
        for (int i = 0; i < len; i++) {
            str[i] = in.nextLine();
            rev[i] = new StringBuilder(str[i]).reverse().toString();
            int strlen = str[i].length();
            if (index[strlen][0] == -1) {
                index[strlen][0] = i;
            } else {
                index[strlen][1] = i;
            }
        }

        char[] ans = new char[len];
        String l = str[index[n-1][0]];
        String r = rev[index[n-1][1]];
        ans[index[n-1][0]] = 'P';
        ans[index[n-1][1]] = 'S';
        boolean flag = true;
        for (int i = n-2; i > 0; i--) {
            int inl = index[i][0];
            int inr = index[i][1];
            int one = l.startsWith(str[inl]) ? 1 : 0;
            one |= r.startsWith(rev[inl]) ? 2 : 0;

            int two = l.startsWith(str[inr]) ? 1 : 0;
            two |= r.startsWith(rev[inr]) ? 2 : 0;

            if (one == two && two != 3) {
                flag = false;
                break;
            }
            if (one == two) {
                ans[inl] = 'P';
                ans[inr] = 'S';
            } else if (one != 3) {
                ans[inl] = one == 1 ? 'P' : 'S';
                ans[inr] = one == 1 ? 'S' : 'P';
            } else {
                ans[inl] = two == 1 ? 'S' : 'P';
                ans[inr] = two == 1 ? 'P' : 'S';
            }

        }

        if (!flag) {
            flag = true;
            l = str[index[n-1][1]];
            r = rev[index[n-1][0]];
            ans[index[n-1][0]] = 'S';
            ans[index[n-1][1]] = 'P';
            for (int i = n-2; i > 0; i--) {
                int inl = index[i][0];
                int inr = index[i][1];
                int one = l.startsWith(str[inl]) ? 1 : 0;
                one |= r.startsWith(rev[inl]) ? 2 : 0;

                int two = l.startsWith(str[inr]) ? 1 : 0;
                two |= r.startsWith(rev[inr]) ? 2 : 0;

                if (one == two && two != 3) {
                    flag = false;
                    break;
                }
                if (one == two) {
                    ans[inl] = 'P';
                    ans[inr] = 'S';
                } else if (one != 3) {
                    ans[inl] = one == 1 ? 'P' : 'S';
                    ans[inr] = one == 1 ? 'S' : 'P';
                } else {
                    ans[inl] = two == 1 ? 'S' : 'P';
                    ans[inr] = two == 1 ? 'P' : 'S';
                }

            }
        }

        for (int i = 0; i < len; i++) {
            out.print(ans[i]);
        }
        out.println();


    }
}
