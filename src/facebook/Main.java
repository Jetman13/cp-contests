package facebook;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("/Users/jetman/code/cp-contests/src/facebook/consistency_chapter_1_input.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("/Users/jetman/code/cp-contests/src/facebook/consistency_chapter__output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A1ConsistencyChapter1 solver = new A1ConsistencyChapter1();
        solver.solve(1, in, out);
        out.close();
    }

    static class A1ConsistencyChapter1 {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int ca = 1; ca <= t; ca++) {

                String str = in.nextLine();
                boolean[] flag = new boolean[300];
                flag['A'] = true;
                flag['E'] = true;
                flag['I'] = true;
                flag['O'] = true;
                flag['U'] = true;
                int ans = Integer.MAX_VALUE;
                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    int num = 0;
                    for (int i = 0; i < str.length(); i++) {
                        char tmp = str.charAt(i);
                        if (tmp == ch) continue;
                        if (flag[tmp] != flag[ch]) {
                            num++;
                        } else {
                            num += 2;
                        }
                    }
                    ans = Math.min(ans, num);
                }
                out.println("Case #" + ca + ": " + ans);
            }
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || (!st.hasMoreElements())) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        public String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}


