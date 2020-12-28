package com.liulu.offer;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n]; // 使用dp数组来存储序列
        dp[0] = 1;//dp[0]已知为1
        int a = 0,b = 0, c = 0; // 下个应该通过乘2来获得新丑数的数据是第a个，同理b，c

        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2,n3),n5);

            if (dp[i] == n2)
                a++; //第a个数应该通过乘2得到了一个新的丑数，那么下次需要通过乘2得到一个新的丑数的树应该是第(a+1)个数
            if (dp[i] == n3)
                b++; //第a个数应该通过乘2得到了一个新的丑数，那么下次需要通过乘2得到一个新的丑数的树应该是第(a+1)个数
            if (dp[i] == n5)
                c++; //第a个数应该通过乘2得到了一个新的丑数，那么下次需要通过乘2得到一个新的丑数的树应该是第(a+1)个数
         }
        return dp[n - 1];
    }
}
