package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DEvenOddGame {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            List<Long> odd = new ArrayList<>();
            List<Long> even = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long tmp = in.nextLong();
                if (tmp%2==0) {
                    even.add(tmp);
                } else {
                    odd.add(tmp);
                }
            }
            even.sort(Collections.reverseOrder());
            odd.sort(Collections.reverseOrder());

            long alice = 0;
            long bob = 0;
            int num = 0;
            int oddIndex = 0;
            int evenIndex = 0;
            while (num < n) {
                long oddVal = oddIndex < odd.size() ? odd.get(oddIndex) : -1;
                long evenVal = evenIndex < even.size() ? even.get(evenIndex) : -1;
                if (num%2==0) {
                    if (evenVal >= oddVal) {
                        evenIndex++;
                        alice += evenVal;
                    } else {
                        oddIndex++;
                    }
                } else {
                    if (evenVal > oddVal) {
                        evenIndex++;
                    } else {
                        oddIndex++;
                        bob += oddVal;
                    }
                }
                num++;
            }

            if (alice == bob) {
                out.println("Tie");
            } else if (alice > bob) {
                out.println("Alice");
            } else {
                out.println("Bob");
            }


        }
    }
}
