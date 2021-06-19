package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CTo3 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long n = in.nextLong();
        if (n%3 == 0) {
            out.println(0);
            return ;
        }
        long[] bitArr = new long[20];
        int bit = getBit(n,bitArr);
        int tmp = (1<<bit);
        int del = 100;
        for (int i = 0; i < tmp; i++) {
            long num = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < bit; j++) {
                if (((1<<j)&i) != 0) {
                    sb.append(bitArr[j]);
                }
            }
            if (sb.length() > 0 && Long.parseLong(sb.toString()) % 3 == 0 && bit - sb.length() < del) {
                del = bit - sb.length();
            }
        }
        out.println(del == 100 ? -1 : del);
    }

    private int getBit(long n,long[] bitArr) {
        int num = 0;
        long[] tmpArr = new long[bitArr.length];
        int index = 0;
        while (n != 0) {
            tmpArr[index++] = n%10;
            num++;
            n/=10;
        }
        for (int i = 0; i < num; i++) {
            bitArr[i] = tmpArr[num-i-1];
        }
        return num;
    }
}
