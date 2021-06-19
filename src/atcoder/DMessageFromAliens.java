package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Stack;

public class DMessageFromAliens {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                p^=1;
            } else {
                if (p == 0) {
                    sb.append(s.charAt(i));
                } else {
                    tmp.append(s.charAt(i));
//                    sb.insert(0,s.charAt(i));
                }
            }
        }

        sb.reverse().append(tmp);

        if (p == 0) {
            sb.reverse();
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == sb.charAt(i)) stack.pop();
            else {
                stack.add(sb.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        out.println(ans.reverse().toString());


    }
}
