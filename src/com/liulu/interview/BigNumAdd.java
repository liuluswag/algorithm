package com.liulu.interview;

/**
 * 大数加法
 */
public class BigNumAdd {

    public String solve (String s, String t) {
        char[] oneCh = s.toCharArray();
        char[] twoCh = t.toCharArray();
        char[] result = new char[Math.max(oneCh.length, twoCh.length) + 1];

        int index = result.length - 1;
        int io = oneCh.length - 1;
        int it = twoCh.length - 1;

        int carry = 0;

        while(io >= 0 && it >= 0){
            int valo = oneCh[io--] - '0';
            int valt = twoCh[it--] - '0';
            int sum = valo + valt + carry;

            result[index--] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        while(io >= 0){
            int sum = oneCh[io--] - '0' + carry;

            result[index--] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        while(it >= 0){
            int sum = twoCh[it--] - '0' + carry;

            result[index--] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry != 0){
            result[index] = (char) ('0' + carry);
            return String.valueOf(result);
        }

        return String.valueOf(result).substring(1);

    }

}
