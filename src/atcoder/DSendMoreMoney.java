package atcoder;

import tool.FastReader;
import tool.Permutation;

import java.io.PrintWriter;
import java.util.*;

public class DSendMoreMoney {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String[] s = new String[3];
        for (int i = 0; i < 3; i++) {
            s[i] = in.nextLine();
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                set.add(s[i].charAt(j));
            }
        }

        if (set.size() > 10) {
            out.println("UNSOLVABLE");
            return ;
        }
        if (s[2].length() < s[0].length() || s[2].length() < s[1].length()) {
            out.println("UNSOLVABLE");
            return ;
        }

        List<Character> chlist = new ArrayList<>();
        for (Character character : set) {
            chlist.add(character);
        }
        chlist.sort(Comparator.naturalOrder());

        Permutation pt = new Permutation();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        long[] ans = null;
        do {
            long[] ns = getNs(a,chlist,s);
            boolean f = true;
            //1
            for (int i = 0; i < 3; i++) {
                if (s[i].length() != String.valueOf(ns[i]).length() || ns[i] == 0) {
                    f = false;
                    break;
                }
            }

            if (ns[0] + ns[1] != ns[2]) {
                f = false;
            }
            if (f) {
                ans = ns;
                break;
            }

        } while (pt.next(a));

        if (ans != null) {
            for (int i = 0; i < 3; i++) {
                out.println(ans[i]);
            }
        } else {
            out.println("UNSOLVABLE");
        }

    }

    private long[] getNs(int[] a, List<Character> chlist, String[] s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chlist.size(); i++) {
            map.put(chlist.get(i),a[i]);
        }

        StringBuilder[] sb = new StringBuilder[3];
        for (int i = 0; i < 3; i++) {
            sb[i] = new StringBuilder();
            for (int j = 0; j < s[i].length(); j++) {
                sb[i].append(map.get(s[i].charAt(j)));
            }
        }

        long[] ans = new long[3];
        for (int i = 0; i < 3; i++) {
            ans[i] = Long.parseLong(sb[i].toString());
        }
        return ans;

    }
}
