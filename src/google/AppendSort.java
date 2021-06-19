package google;

import tool.FastReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class AppendSort {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.next();
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (max(a[i],a[i-1])) continue;
            if (a[i].equals(a[i-1])) {
                a[i] += "0";
                ans++;
                continue;
            }

            String preStr = a[i-1] + "";
            String str = a[i] + "";
            if (preStr.charAt(0) > str.charAt(0)) {
                for (int j = 0; j < preStr.length() - str.length() + 1; j++) {
                    a[i] += "0";
                    ans++;
                }
            } else if (preStr.charAt(0) < str.charAt(0)) {
                for (int j = 0; j < preStr.length() - str.length(); j++) {
                    a[i] += "0";
                    ans++;
                }
            } else {
                String preSub = preStr.substring(0,str.length());
                String sub = str;
                if (preSub.compareTo(sub) > 0) {
                    for (int j = 0; j < preStr.length() - str.length() + 1; j++) {
                        a[i] += "0";
                        ans++;
                    }
                } else if (preSub.compareTo(sub) < 0) {
                    for (int j = 0; j < preStr.length() - str.length(); j++) {
                        a[i] += "0";
                        ans++;
                    }
                } else {
                    String tmp = preStr.substring(str.length());
                    boolean f = true;
                    for (int j = 0; j < tmp.length(); j++) {
                        if (tmp.charAt(j) != '9') {
                            f = false;
                        }
                    }
                    if (f) {
                        for (int j = 0; j < preStr.length() - str.length() + 1; j++) {
                            a[i] += "0";
                            ans++;
                        }
                    } else {
                        for (int j = 0; j < preStr.length() - str.length(); j++) {
                            //a[i] = a[i]*10 + 9;
                            ans++;
                        }
                        a[i] = new BigDecimal(a[i-1]).add(new BigDecimal(1)).toString();
                    }
                }

            }
        }
        out.println("Case #" + testNumber + ": " + ans);
    }

    boolean max(String s,String s1) {
        if (s.length() > s1.length()) return true;
        if (s.length() < s1.length()) return false;
        return s.compareTo(s1) > 0;
    }
}
