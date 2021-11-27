package atcoder;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CReorderCards {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int h = in.nextInt();
        int w = in.nextInt();
        int n = in.nextInt();
        Set<Integer> harr = new TreeSet<>();
        Set<Integer> warr = new TreeSet<>();
        int[][] point = new int[n][2];
        for (int i = 0; i < n; i++) {
            point[i][0] = in.nextInt();
            point[i][1] = in.nextInt();
            harr.add(point[i][0]);
            warr.add(point[i][1]);
        }


        Map<Integer,Integer> hmap = new HashMap<>();
        Map<Integer,Integer> wmap = new HashMap<>();
        int i = 1;
        for (Integer tmp : harr) {
            hmap.put(tmp,i++);
        }
        i = 1;
        for (Integer tmp : warr) {
            wmap.put(tmp,i++);
        }

        for (int j = 0; j < n; j++) {
            out.println(hmap.get(point[j][0]) + " " + wmap.get(point[j][1]));
        }


    }
}
