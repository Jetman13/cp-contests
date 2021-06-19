package codeforces;

public class BallotCounting {
    public int count(String votes) {

        int len = votes.length();

        int a = 0;
        int ans = len;
        for (int i = 0; i < len; i++) {
            if (votes.charAt(i) == 'A') a++;
            if (a > len/2 || i - a + 1 > len/2) {
                ans = i+1;
                break;
            }
        }

        return ans;
    }
}
