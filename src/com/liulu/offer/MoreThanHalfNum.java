package com.liulu.offer;

/**
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = array[0];
        int count = 1;
        for (int i = 1; i < array.length ; i++){
            if (array[i] == res)
                count++;
            else
                count--;
            if (count == 0){
                res = array[i];
                count = 1;
            }
        }
        count = 0;
        for (int j : array) {
            if (res == j)
                count++;
        }
        if (count > array.length / 2)
            return res;
        return res;
    }
}
