package com.lottery.test;

/**
 * 01背包问题 动态规划
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-11-02
 * Time: 16:58
 */
public class PackDemo {

    /**
     *
     * @param n 物品数量
     * @param m 背包总容量
     * @param w 物品重量数组
     * @param p 物品价值数组
     */
    public static int getMaxPrice(int n, int m, int[] w, int[] p) {
        int[][] c = new int[n+2][m+2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (w[i-1] > j) {
                    c[i][j] = c[i-1][j];
                    continue;
                } else if (c[i-1][j-w[i-1]] + p[i-1] > c[i-1][j] ) {
                    c[i][j] = c[i-1][j-w[i-1]] + p[i-1];
                } else {
                    c[i][j] = c[i-1][j];
                }
            }
        }
        return c[n][m];
    }

    public static void main(String...args) {
        int[] w = {2,2,6,5,4};
        int[] p = {6,3,5,4,6};
        int n = 5;
        int m = 10;
        int v = getMaxPrice(n, m, w, p);
        System.out.println(v);
    }
}
