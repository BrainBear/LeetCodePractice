package me.brainbear.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        for (int j = 0; j < nums.length - 3; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) continue;
            for (int i = j + 1; i < nums.length - 2; i++) {
                if (i > j + 1 && nums[i] == nums[i - 1]) continue;
                int start = i + 1;
                int end = nums.length - 1;

                int temp = target - nums[i] - nums[j];
                while (start < end) {
                    if (nums[start] + nums[end] == temp) {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[j]);
                        list.add(nums[i]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        result.add(list);
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < temp) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        L18FourSum fourSum = new L18FourSum();

//        System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        System.out.println(fourSum.fourSum(new int[]{0, 0, 0, 0}, 0));
//        System.out.println(fourSum.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
        System.out.println(fourSum.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));

    }
}
