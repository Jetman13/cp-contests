package google;

import tool.CommonUtils;
import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HackedExam {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        int q = in.nextInt();
        String[] str = new String[n];
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
            score[i] = in.nextInt();
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < (1<<q); i++) {
            int[] sco = new int[n];
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < q; j++) {
                char ch = ((i&(1<<j)) > 0) ? 'T' : 'F';
                tmp.append(ch);
                for (int k = 0; k < n; k++) {
                    sco[k] += str[k].charAt(j) == ch ? 1 : 0;
                }
            }

            boolean f = true;
            for (int j = 0; j < n; j++) {
                if (score[j] != sco[j]) {
                    f = false;
                }
            }
            if (f) {
                list.add(tmp.toString());
            }
            
        }

        int maxS = 0;
        String maxStr = "";
        for (int i = 0; i < (1<<q); i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < q; j++) {
                char ch = ((i&(1<<j)) > 0) ? 'T' : 'F';
                tmp.append(ch);
            }

            String tmpStr = tmp.toString();
            int s = 0;
            for (int j = 0; j < list.size(); j++) {
                s += cal(tmpStr,list.get(j));
            }
            if (maxS < s) {
                maxS = s;
                maxStr = tmpStr;
            }
        }

        long gcd = CommonUtils.gcd(maxS,list.size());
        out.println("Case #" + testNumber + ": " + maxStr + " " + (maxS/gcd) + "/" + (list.size()/gcd));

    }

    private int cal(String tmpStr, String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += tmpStr.charAt(i) == s.charAt(i) ? 1 : 0;
        }
        return ans;
    }
}
