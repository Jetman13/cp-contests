package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class BinaryStringMEX {
    class Node {
        int one;
        int zero;

        public Node(int one, int zero) {
            this.one = one;
            this.zero = zero;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
//        int t = in.nextInt();
//        while (t-- > 0) {
//            String s = in.nextLine();
//            work(s);
//
//        }
        for (int i = 0; i < (1<<10); i++) {
            String s = Integer.toBinaryString(i);
            String work = work(s);
            String forces = forces(s);
            if (!work.equals(forces)) {
                out.println("s:"+s + " work:"+work+" forces:"+forces);
            }
        }
    }

    private String work(String s) {
        int len = s.length();
        if (len == 1) {
            return ((s.charAt(0) - '0')^1) + "";
        }

        int[] sum = new int[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i] + s.charAt(i) - '0';
        }
        int[] zerosum = new int[len+2];
        for (int i = len-1; i >= 0; i--) {
            zerosum[i+1] = zerosum[i+2] + ((s.charAt(i)-'0')^1);
        }
        if (zerosum[1] == 0) {
            return "0";
        }
        if (sum[len] == 0) {
            return "1";
        }

        String tmp = s + "*";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (tmp.charAt(i) != tmp.charAt(i+1)) {
                ans.append(tmp.charAt(i));
            }
        }
        if (len > 1 && s.charAt(len-1) == s.charAt(len-2) && s.charAt(len-1) == '0') {
            ans.append(1);
        } else {
            ans.append(0);
        }

        Node node = new Node(sum[len]+1,0);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                node = max(node,new Node(sum[i+1],zerosum[i+1]+1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < node.one; i++) {
            sb.append(1);
        }
        for (int i = 0; i < node.zero; i++) {
            sb.append(0);
        }
        if (ans.length() != sb.length()) {
            return (ans.length() < sb.length() ? ans.toString() : sb.toString());
        } else {
            return (ans.toString().compareTo(sb.toString()) > 0 ? sb.toString() : ans.toString());
        }
    }

    private Node max(Node node, Node node1) {
        if (node.one + node.zero == node1.one + node1.zero) {
            return node.one < node1.one ? node : node1;
        } else {
            return (node.one + node.zero < node1.one + node1.zero) ? node : node1;
        }
    }


    String forces(String s) {

        String ansStr = s + "0";

        int len = s.length();
        for (int i = 0; i < (1 << len); i++) {
            String ans = check(s, i);
            if (ans != null) {
                if (max(ansStr, ans)) {
                    ansStr = ans;
                }
            }
        }
        return ansStr;

    }

    boolean max(String a, String b) {
        if (a.length() > b.length()) return true;
        if (a.length() < b.length()) return false;
        return a.compareTo(b) > 0;
    }

    private String check(String s, int i) {
        StringBuilder sb = new StringBuilder();
        while (i != 0) {
            sb.append(i % 2);
            i /= 2;
        }
        if (sb.length() <= 0) sb.append("0");

        String ans = sb.reverse().toString();

        int p = 0;
        boolean f = false;
        for (int j = 0; j < ans.length(); j++) {
            while (p < s.length() && s.charAt(p) != ans.charAt(j)) p++;


            if (p >= s.length()) {
                f = true;
                break;
            }
            p++;

        }

        return f ? ans : null;


    }


}
