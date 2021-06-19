package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Stack;

public class CMoveBrackets {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.nextLine();

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                int k = (s.charAt(i) == '(') ? 1 : 0;
                if (!stack.isEmpty() && (stack.peek()^k) == 1 && stack.peek() == 1) {
                    stack.pop();
                } else {
                    stack.add(k);
                }
            }
            out.println(stack.size()/2);

        }
    }
}
