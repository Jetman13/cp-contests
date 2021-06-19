package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Jetman
 * @create: 2021-03-09 20:34
 **/
public class Kotlin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        boolean[] f = new boolean[1002];
        List<Integer> list = new ArrayList<>();
        for (int i = n-1; i >=0 ; i--) {
            if (!f[a[i]]) {
                list.add(a[i]);
            }
            f[a[i]] = true;
        }
        System.out.println(list.size());
        for (int i = list.size()-1; i >=0 ; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
