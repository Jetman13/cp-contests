package google;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MoonsAndUmbrellas {
    Map<String,Integer> map;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        String s = in.next();

        map = new HashMap();
        map.put("CJ",x);
        map.put("JC",y);

        s = "A" + s + "A";
        char[] chs = s.toCharArray();
        int len = chs.length;
        for (int i = 1; i < len-1; i++) {
            if (chs[i] != '?') continue;
            int e = i;
            while (chs[e] == '?') e++;
            //J
            setAll(chs,i,e-1,'J');
            int min = (chs[i-1] == 'C' ? x : 0) + (chs[e] == 'C' ? y : 0);
            //C
            int tmpmin = (chs[i-1] == 'J' ? y : 0) + (chs[e] == 'J' ? x : 0);
            if (tmpmin < min) {
                min = tmpmin;
                setAll(chs,i,e-1,'C');
            }
            //JC
            tmpmin = (chs[i-1] == 'C' ? x : 0) ;
            tmpmin += ((e-i)/2)*y + ((e-i-1)/2)*x;
            String key = ((e-i)%2==0 ? "C" : "J") + chs[e];
            tmpmin += map.getOrDefault(key,0);
            if (tmpmin < min) {
                min = tmpmin;
                setAll(chs,i,e-1,0);
            }
            //CJ
            tmpmin = (chs[i-1] == 'J' ? y : 0) ;
            tmpmin += ((e-i)/2)*x + ((e-i-1)/2)*y;
            key = ((e-i)%2==0 ? "J" : "C") + chs[e];
            tmpmin += map.getOrDefault(key,0);
            if (tmpmin < min) {
                min = tmpmin;
                setAll(chs,i,e-1,1);
            }


//            char sc = chs[i-1];
//            char ec = chs[e];
//            if (sc == ec) {
//                char tmp = sc;
//                if (tmp == 'A') tmp = 'J';
//                setAll(chs,i,e-1,tmp);
//
//            } else if (sc == 'A' || ec == 'A') {
//                char tmp = sc == 'A' ? ec : sc;
//                setAll(chs,i,e-1,tmp);
//            } else {
//                char tmp = 'J';
//                setAll(chs,i,e-1,tmp);
//            }
        }

        int ans = 0;
        for (int i = 1; i < len-2; i++) {
            if (chs[i] == 'J' && chs[i+1] == 'C') ans += y;
            if (chs[i] == 'C' && chs[i+1] == 'J') ans += x;
        }
        out.println("Case #" + testNumber + ": " + ans);

    }

    private void setAll(char[] chs, int s, int e, int tmp) {
        char[] swap = new char[]{'J','C'};
        for (int i = 0; i + s <= e; i++) {
                chs[i+s] = swap[(i+tmp)%2];
        }
    }

    private void setAll(char[] chs, int s, int e, char tmp) {
        for (int i = s; i <= e ; i++) {
            chs[i] = tmp;
        }
    }
}
