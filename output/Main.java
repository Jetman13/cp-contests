import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CChallengingCliffs solver = new CChallengingCliffs();
        solver.solve(1, in, out);
        out.close();
    }

    static class CChallengingCliffs {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int[] a = new int[n];
                in.readArr(a);

                RuffleSort.ruffleSort(a);

                int p = 0;
                int max = a[1] - a[0];
                for (int i = 1; i < n - 1; i++) {
                    int tmp = a[i + 1] - a[i];
                    if (tmp < max) {
                        max = tmp;
                        p = i;
                    }
                }

                List<Integer> list = new ArrayList<>();
                list.add(a[p]);
                for (int i = p + 2; i < n; i++) {
                    list.add(a[i]);
                }
                for (int i = 0; i < p; i++) {
                    list.add(a[i]);
                }
                list.add(a[p + 1]);
                for (int i = 0; i < n; i++) {
                    out.print(list.get(i) + " ");
                }
                out.println();
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

        public void readArr(int[] a) {
            for (int i = 0; i < a.length; i++) {
                a[i] = nextInt();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class RuffleSort {
        public static void ruffleSort(int[] a) {
            Random get = new Random();
            for (int i = 0; i < a.length; i++) {
                int r = get.nextInt(a.length);
                int temp = a[i];
                a[i] = a[r];
                a[r] = temp;
            }
            Arrays.sort(a);
        }

    }
}

