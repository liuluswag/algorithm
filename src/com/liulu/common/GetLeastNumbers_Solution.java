package com.liulu.common;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums,int k){
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums, k-1);
        for(int i = 0; i < k; i++){
            ret.add(nums[i]);
        }
        return ret;
    }

    private void findKthSmallest(int[] nums, int k) {
        int l = 0,h = nums.length - 1;
        while(l < h){
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private int partition(int[] nums, int l, int h){
        int p = nums[l];
        int i = l,j = h + 1;
        while (true){
            while (i != h && nums[++i] < p);
            while (j != l && nums[--j] > p);
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * 维护大根堆，将大于k的元素去除，剩下的元素都比被去除的元素小
     * @param nums
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] nums,int k){
        if (k > nums.length || k <= 0){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2 -o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }


}
