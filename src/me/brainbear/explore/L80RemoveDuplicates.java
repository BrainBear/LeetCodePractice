package me.brainbear.explore;

import java.util.Arrays;

public class L80RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if(null == nums || nums.length == 0){
            return 0;
        }

        int insertIndex = 1;
        int repeatCount = 1;

        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                repeatCount++;
                if (repeatCount <= 2) {
                    nums[insertIndex++] = nums[i];
                }
            } else {
                repeatCount = 1;
                nums[insertIndex++] = nums[i];
                prev = nums[i];
            }
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        L80RemoveDuplicates removeDuplicates = new L80RemoveDuplicates();
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

        System.out.println(Arrays.toString(nums));
        int ret = removeDuplicates.removeDuplicates(nums);
        System.out.println("ret:" + ret + " " + Arrays.toString(nums));
    }
}
