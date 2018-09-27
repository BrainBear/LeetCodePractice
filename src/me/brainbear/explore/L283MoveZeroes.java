package me.brainbear.explore;

import java.util.Arrays;

public class L283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        L283MoveZeroes moveZeroes = new L283MoveZeroes();
        int[] nums = new int[]{0,1,0,3,12};

        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
