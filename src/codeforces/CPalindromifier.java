package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CPalindromifier {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String fps = in.nextLine();

        work(fps);


    }

    private void work(String fps) {
        int index = 0;
        int len = fps.length();
        while (index < len) {
            String title = fps.substring(index,index+2);
            String l = fps.substring(index+2,index+4);
            String content = fps.substring(index+4,index + 4 + Integer.parseInt(l));
            index+=4 + Integer.parseInt(l);
            System.out.println(title + " " + l + " " + content);
        }
    }
}
