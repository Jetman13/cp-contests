package atcoder;

public class OpenAllHours {

    String yes = "correct";
    String no = "incorrect";
    public String verify(int n, String[] openingTime, String[] closingTime) {

        boolean flag[] = new boolean[24*60];
        for (int i = 0; i < n; i++) {
            int l = Integer.parseInt(openingTime[i].split(":")[0]) * 60 + Integer.parseInt(openingTime[i].split(":")[1]);
            int r = Integer.parseInt(closingTime[i].split(":")[0]) * 60 + Integer.parseInt(closingTime[i].split(":")[1]);
            if (l == r) return yes;
            if (l > r) {
                fill(l,24*60,flag);
                fill(0,r,flag);
            } else {
                fill(l,r,flag);
            }
        }
        boolean f = true;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == false) {
                f = false;
                break;
            }
        }

        return f ? yes : no;
    }

    private void fill(int l, int r, boolean[] flag) {
        for (int i = l; i < r; i++) {
            flag[i] = true;
        }
    }
}
