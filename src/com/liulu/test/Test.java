package com.liulu.test;

import java.util.HashMap;
import java.util.Stack;

public class Test {


    public static void reverseString(char[] s) {
        char temp = ' ';
        int n = s.length;
        for(int i = 0; i < n / 2; i++){
            temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums2.length; i++){
            while(!stack.empty() && nums2[i] > stack.peek()){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.empty()){
            map.put(stack.pop(), -1);
        }
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
        int[] res = nextGreaterElement(nums1, nums2);
        for (int i : res){
            System.out.println(i);
        }
    }

}
