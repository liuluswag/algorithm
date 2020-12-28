package com.liulu.offer;

/**
 * 礼物的最大价值
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = i > 0 ? dp[i-1][j] : 0;
                int left = j > 0 ? dp[i][j-1] : 0;
                dp[i][j] = Math.max(left, top) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }

    int[][] solution;//用来记录解，减少递归计算
    public int maxValue2(int[][] grid) {
        int n=grid.length ,m=grid[0].length;
        return dfs(grid,0,0,n,m);
    }

    private int dfs(int[][] grid, int i, int j, int n, int m) {
        if (i == n || j == m)
            return 0;
        if (solution[i][j] > 0) //已经求过解直接返回
            return solution[i][j];
        int right = dfs(grid, i, j + 1, n, m);//向右走获得的最大值
        int down = dfs(grid, i + 1, j, n, m);//向下走获得的最大值
        solution[i][j] = Math.max(right, down) + grid[i][j];//记录解
        return solution[i][j];
    }
}
