package me.brainbear.explore;

import java.util.Arrays;

public class L189Rotate {


    private void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end - 1];
            nums[end - 1] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, 0, nums.length - k);
        rotate(nums, nums.length - k, nums.length);
        rotate(nums, 0, nums.length);
    }


    public static void main(String[] args) {
        L189Rotate rotate = new L189Rotate();
        int[] nums = new int[]{-1};

        rotate.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
