package tool;

/**
 * @description:
 * @author: Jetman
 * @create: 2020-10-10 22:48
 **/
public class FenwichTree {

    private int[] sums;
    private int[] nums;

    public FenwichTree(int[] nums) {
        this.sums = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            updateBit(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        updateBit(i + 1, val - nums[i]);
        nums[i] = val;
    }

    private void updateBit(int i, int diff) {
        while (i < sums.length) {
            sums[i] += diff;
            i += lowBit(i);
        }
    }

    public int sumRange(int i, int j) {
        return preSum(j + 1) - preSum(i);
    }

    private int preSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += sums[i];
            i -= lowBit(i);
        }
        return sum;
    }

    private int lowBit(int i) {
        return i & (-i);
    }
}
