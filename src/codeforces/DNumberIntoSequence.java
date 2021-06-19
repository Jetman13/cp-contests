package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

public class DNumberIntoSequence {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long N = n;
            Map<Integer,Integer> map = new TreeMap<>();
            for (int i = 2; (long)i*i <= n; i++) {
                if (n%i != 0) continue;
                n/=i;
                int num = map.getOrDefault(i,0);
                map.put(i,num+1);
                i--;
            }
            if (n != 1) {
                int num = map.getOrDefault((int)n, 0);
                map.put((int)n, num + 1);
            }
            if (map.size() <= 0) {
                out.println(1);
                out.println(N);
            } else {

                int tmp = 0;
                int maxNum = 0;
                int maxIndex = 0;
                for (Map.Entry<Integer, Integer> keyval : map.entrySet()) {
                    if (keyval.getValue() > maxNum) {
                        maxNum = keyval.getValue();
                        maxIndex = keyval.getKey();
                    }
                    tmp+=keyval.getValue();
                }

                out.println(maxNum);
                for (int i = 0; i < maxNum-1; i++) {
                    out.print(maxIndex+" ");
                    N/=maxIndex;
                }
                out.println(N);

            }

        }
    }
}
