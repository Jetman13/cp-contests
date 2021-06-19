package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class Lin88sPalindrome {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();

        int len = s.length();

        boolean[] f = new boolean[len];

        int size = 0;
        for (int i = 0; i <= len/2; i++) {
            f[i] = (s.charAt(i) == s.charAt(len-i-1));
            if (f[i]) size++;
        }
        char[] chs = s.toCharArray();
        
        int mid = len/2 + 1;
        
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int index = in.nextInt() - 1;
            char ch = in.next().charAt(0);

            chs[index] = ch;

            int p = index >= mid ? (len - index - 1) : index;
            boolean old = f[p];
            boolean ne = chs[p] == chs[len - p - 1];
            f[p] = ne;
            if (!old && ne) {
                size++;
            }

            if (old && !ne) {
                size--;
            }

            out.println((size == mid) ? "Yes" : "No");

        }
        
        
    }
}
