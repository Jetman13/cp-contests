package codeforces;

public class TableTennisGame {
    public int[] finalScore(int a, int b) {
        if (a + b < 11) return new int[0];
        if (a + b > 20 && a != b) return new int[0];
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        if (a + b <= 20 && (max > min+2 || (max%2==1 && min%2==1))) return new int[0];

        if (a + b <= 20) return new int[]{11,a+b-11};
        return new int[]{a+1,b-1};
    }
}
