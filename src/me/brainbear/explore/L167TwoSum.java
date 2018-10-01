package me.brainbear.explore;

import java.util.Arrays;

public class L167TwoSum {

    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        int[] ret = new int[2];

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                ret[0] = i + 1;
                ret[1] = j + 1;
                break;
            }

        }
        return ret;
    }


    public static void main(String[] args) {
        L167TwoSum twoSum = new L167TwoSum();

        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
    }
}
