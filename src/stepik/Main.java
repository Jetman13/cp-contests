package stepik;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
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
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("/Users/jetman/code/cp-contests/src/stepik/5.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("/Users/jetman/code/cp-contests/output/output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        MetaboliteAnnotation solver = new MetaboliteAnnotation();
        solver.solve(1, in, out);
        out.close();
    }

    static class MetaboliteAnnotation {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            while (t-- > 0) {
                int m = in.nextInt();
                int k = in.nextInt();
                int n = in.nextInt();
                double[] mval = new double[m];
                double[] kval = new double[k];
                double[] nval = new double[n];
                in.readArr(mval);
                in.readArr(kval);
                in.readArr(nval);

                List<Node> list = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    list.add(new Node(mval[i],i+1,0));
                }

                list.sort((aa, bb) -> {
                    if (aa.val > bb.val) return 1;
                    else if (aa.val < bb.val) return -1;
                    else return 0;
                });

                for (int i = 0; i < n; i++) {
                    Node min = new Node(10000000.0,0,0);
                    for (int j = 0; j < k; j++) {
                        Node node = getNode(list,kval[j],nval[i]);
                        if (node != null) {
                            if (node.val < min.val) {
                                node.ki = j+1;
                                min = node;
                            }
                        }
                    }
                    out.println(min.mi + " " + min.ki);
                }


            }
        }

        private Node getNode(List<Node> list, double kval,double nval) {
            double abs = 100000000.0;
            int i = 0, j = 0;
            int l = 0;
            int r = list.size() - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                Node node = list.get(mid);
                if (node.val + kval < 0) {
                    l = mid + 1;
                    continue;
                }
                if (Math.abs(node.val + kval - nval) < abs) {
                    i = node.mi;
                    j = node.ki;
                    abs = Math.abs(node.val + kval - nval);
                }
                if (node.val + kval > nval) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (i == 0) return null;
            return new Node(abs, i, j);
        }

        class Node {
            double val;
            int mi;
            int ki;

            public Node(double val, int mi, int ki) {
                this.val = val;
                this.mi = mi;
                this.ki = ki;
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

        public void readArr(double[] a) {
            for (int i = 0; i < a.length; i++) {
                a[i] = nextDouble();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}


