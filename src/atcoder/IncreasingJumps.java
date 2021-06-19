package atcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncreasingJumps {
    public int[] jump(int[] frogs) {
        int n = frogs.length;
        List<Integer> ans = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < n; i++) {
            int target = i;
            int tmp = Math.abs(target - frogs[i]);
            for (int j = 0; j < tmp; j++) {
                if (target < frogs[i]) {
                    ans.add(i+1);
                    index++;
                    ans.add(-(i+1));
                    index++;
                } else {
                    ans.add(-(i+1));
                    index++;
                    ans.add(i+1);
                    index++;
                }
            }
        }
        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}
