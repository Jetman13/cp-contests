package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Stack;

public class AABCString {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            String str = in.nextLine();
            boolean flag = false;
            for (int i = 0; i < (1<<3); i++) {
                int[] chs = new int[str.length()];
                for (int j = 0; j < str.length(); j++) {
                    char chtmp = str.charAt(j);
                    if (chtmp == 'A') {
                        if ((i&(1)) > 0) {
                            chs[j] = 0;
                        } else {
                            chs[j] = 1;
                        }
                    } else if (chtmp == 'B') {
                        if ((i&(1<<1)) > 0) {
                            chs[j] = 0;
                        } else {
                            chs[j] = 1;
                        }

                    } else {
                        if ((i&(1<<2)) > 0) {
                            chs[j] = 0;
                        } else {
                            chs[j] = 1;
                        }
                    }
                }

                if (check(chs)) {
                    flag = true;
                    break;
                }
            }
            out.println(flag ? "YES":"NO");
        }
    }

    private boolean check(int[] chs) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chs.length; i++) {
            if (!stack.isEmpty() && stack.peek() == 0 && chs[i] == 1) {
                stack.pop();
            } else {
                stack.push(chs[i]);
            }
        }
        return stack.isEmpty();
    }
}
