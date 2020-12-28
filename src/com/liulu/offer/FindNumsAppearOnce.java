package com.liulu.offer;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = array[0];
        //首先数组中的数字全部完成异或
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }
        //把异或结果的最后一位1的那位找出来
        temp &= - temp;
        //以这一位是否为1或者0作为分类标准进行分类
        for (int val : array) {
            if ((val & temp) == 0)
                num1[0] ^= val;
            else
                num2[0] ^= val;
        }
    }
}
