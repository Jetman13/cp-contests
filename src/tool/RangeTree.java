package tool;

/**
 * @description:
 * @author: Jetman
 * @create: 2020-10-10 22:47
 **/
public class RangeTree {
    private long[] max;
    private long[] min;
    private long[] lazy;
    private long[] sum;
    private int size;
    public RangeTree(int size) {
        this.size = size;
        max = new long[4*size];
        min = new long[4*size];
        sum = new long[4*size];
        lazy = new long[4*size];
    }
    public void update(int l, int r, long inc) {
        update(1, 0, size-1, l, r, inc);
    }
    private void pushDown(int index, int l, int r) {
        min[index] += lazy[index];
        max[index] += lazy[index];
        sum[index] += lazy[index] * (r-l+1);
        if(l != r) {
            lazy[2*index] += lazy[index];
            lazy[2*index+1] += lazy[index];
        }
        lazy[index] = 0;
    }
    private void pullUp(int index, int l, int r) {
        int m = (l+r)/2;
        min[index] = Math.min(evaluateMin(2*index, l, m), evaluateMin(2*index+1, m+1, r));
        max[index] = Math.max(evaluateMax(2*index, l, m), evaluateMax(2*index+1, m+1, r));
        sum[index] = evaluateSum(2*index, l, m) + evaluateSum(2*index+1, m+1, r);
    }
    private long evaluateSum(int index, int l, int r) {
        return sum[index] + (r-l+1)*lazy[index];
    }
    private long evaluateMin(int index, int l, int r) {
        return min[index] + lazy[index];
    }
    private long evaluateMax(int index, int l, int r) {
        return max[index] + lazy[index];
    }
    private void update(int index, int l, int r, int left, int right, long inc) {
        if(r < left || l > right) return;
        if(l >= left && r <= right) {
            lazy[index] += inc;
            return;
        }
        pushDown(index, l, r);
        int m = (l+r)/2;
        update(2*index, l, m, left, right, inc);
        update(2*index+1, m+1, r, left, right, inc);
        pullUp(index, l, r);
    }
    public long minQuery(int l, int r) {
        return minQuery(1, 0, size-1, l, r);
    }
    private long minQuery(int index, int l, int r, int left, int right) {
        if(r < left || l > right) return Long.MAX_VALUE;
        if(l >= left && r <= right) {
            return evaluateMin(index, l, r);
        }
        pushDown(index, l, r);
        int m = (l+r)/2;
        long ret = Long.MAX_VALUE;
        ret = Math.min(ret, minQuery(2*index, l, m, left, right));
        ret = Math.min(ret, minQuery(2*index+1, m+1, r, left, right));
        pullUp(index, l, r);
        return ret;
    }
    public long maxQuery(int l, int r) {
        return maxQuery(1, 0, size-1, l, r);
    }
    private long maxQuery(int index, int l, int r, int left, int right) {
        if(r < left || l > right) return Long.MIN_VALUE;
        if(l >= left && r <= right) {
            return evaluateMax(index, l, r);
        }
        pushDown(index, l, r);
        int m = (l+r)/2;
        long ret = Long.MIN_VALUE;
        ret = Math.max(ret, maxQuery(2*index, l, m, left, right));
        ret = Math.max(ret, maxQuery(2*index+1, m+1, r, left, right));
        pullUp(index, l, r);
        return ret;
    }
    public long sumQuery(int l, int r) {
        return sumQuery(1, 0, size-1, l, r);
    }
    private long sumQuery(int index, int l, int r, int left, int right) {
        if(r < left || l > right) return 0;
        if(l >= left && r <= right) {
            return evaluateSum(index, l, r);
        }
        pushDown(index, l, r);
        int m = (l+r)/2;
        long ret = 0;
        ret += sumQuery(2*index, l, m, left, right);
        ret += sumQuery(2*index+1, m+1, r, left, right);
        pullUp(index, l, r);
        return ret;
    }
}
