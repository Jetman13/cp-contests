package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class DPoker {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int k = in.nextInt();
        String s = in.nextLine();
        String t = in.nextLine();

        int[] num = new int[10];
        Arrays.fill(num,k);
        num[0] = 0;

        for (int i = 0; i < s.length()-1; i++) {
            num[s.charAt(i)-'0']--;
            num[t.charAt(i)-'0']--;
        }

        double ans = 0.0;
        for (int i = 1; i < 10; i++) {
            if (num[i] <= 0) continue;
            for (int j = 1; j < 10; j++) {
                if (j==i && num[j] <= 1) continue;
                if (j!=i && num[j] <= 0) continue;
                if (score(s,i) > score(t,j)) {
                    ans += cal(i,j,num);
                }
            }
        }
        out.println(ans);

    }

    private double cal(int i, int j, int[] num) {
        long sum = Arrays.stream(num).sum();
        sum = sum*(sum-1);

        long p = 0;
        if (i == j) {
            p = num[i]*(long)(num[i]-1);
        } else {
            p = num[i]*(long)num[j];
        }
        return (double)p/(double)sum;
    }

    private int score(String t, int j) {
        int[] sco = new int[10];
        for (int i = 0; i < t.length()-1; i++) {
            sco[t.charAt(i)-'0']++;
        }
        sco[j]++;

        int s = 0;
        int[] pow = new int[8];
        pow[0] = 1;
        for (int i = 1; i < 7; i++) {
            pow[i] = pow[i-1]*10;
        }
        for (int i = 1; i < 10; i++) {
            s += i*pow[sco[i]];
        }
        return s;

    }

}
