package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @description:
 * @author: Jetman
 * @create: 2020-10-10 22:42
 **/
public class FastReader {
    BufferedReader br;
    StringTokenizer st = new StringTokenizer("");

    public FastReader() {
        br =new BufferedReader(new InputStreamReader(System.in));
    }
    public FastReader(InputStream in) {
        br =new BufferedReader(new InputStreamReader(in));
    }

    public String next() {
        while (st==null || (!st.hasMoreElements()))
        {
            try
            {
                st =new StringTokenizer(br.readLine());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

        }
        return st.nextToken();
    }

    public String nextLine() {
        String str ="";

        try
        {
            str =br.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return str;
    }

    public void readArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = nextInt();
        }
    }
    public void readArr(long[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = nextLong();
        }
    }
    public void readArr(double[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = nextDouble();
        }
    }

    public void readArr(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = nextInt();
            }
        }
    }
    public void readArr(long[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = nextLong();
            }
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next()) ;
    }
}
