package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Stack;

public class BRBSDeletion {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String str = in.nextLine();
            Stack<Character> stack = new Stack<>();
            int ans = 0;
            int num = 0;
            int pre = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(') {
                    stack.add(ch);
                } else {
                    if (!stack.isEmpty() && stack.peek() != ch) {
                        stack.pop();
                    } else {
                        stack.add(ch);
                    }
                }
                if (stack.isEmpty()) {
                    ans++;
                    num += (i - pre + 1 - 2)/2;
                    pre = i+1;
                }
            }
            ans += num >=k?k:num;
            out.println(ans);
        }
    }
}
