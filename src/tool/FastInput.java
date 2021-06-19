package tool;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Jetman
 * @create: 2020-11-05 21:31
 **/
public class FastInput {
    private final InputStream is;
    private byte[] buf = new byte[1 << 13];
    private int bufLen;
    private int bufOffset;
    private int next;


    public FastInput(InputStream is) {
        this.is = is;
    }

    private int read() {
        while (bufLen == bufOffset) {
            bufOffset = 0;
            try {
                bufLen = is.read(buf);
            } catch (IOException e) {
                bufLen = -1;
            }
            if (bufLen == -1) {
                return -1;
            }
        }
        return buf[bufOffset++];
    }

    public void skipBlank() {
        while (next >= 0 && next <= 32) {
            next = read();
        }
    }

    public int nextInt() {
        int sign = 1;

        skipBlank();
        if (next == '+' || next == '-') {
            sign = next == '+' ? 1 : -1;
            next = read();
        }

        int val = 0;
        if (sign == 1) {
            while (next >= '0' && next <= '9') {
                val = val * 10 + next - '0';
                next = read();
            }
        } else {
            while (next >= '0' && next <= '9') {
                val = val * 10 - next + '0';
                next = read();
            }
        }

        return val;
    }



}
