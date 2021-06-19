package tool;

/**
 * @description: 全排列
 * @author: Jetman
 * @create: 2020-10-12 20:46
 **/
public class Permutation {
    public boolean next(int[] a) {
        int n = a.length;

        int i = n - 1;
        while (i > 0 && a[i - 1] >= a[i]) i--;
        if (i <= 0) return false;

        int j = n - 1;
        while (a[j] <= a[i - 1]) j--;
        swap(a, i - 1, j);

        int k = n - 1;
        while (i < k) swap(a, i++, k--);

        return true;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
