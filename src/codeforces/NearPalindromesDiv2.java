package codeforces;

public class NearPalindromesDiv2 {
    public String solve(String s) {
        int[] num = new int[30];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 'a';
            if (num[tmp]%2 == 1) {
                int j = 0;
                for (; j < tmp; j++) {
                    if (num[j]%2 == 1) {
                        break;
                    }
                }
                if (j < tmp) {
                    sb.append((char)(j+'a'));
                    num[j]++;
                    num[tmp]--;
                } else {
                    sb.append((char)(tmp+'a'));
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
