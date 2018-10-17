package me.brainbear.explore;

import java.util.*;

public class L15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int start = i + 1;
            int end = nums.length - 1;

            int target = 0 - nums[i];
            while (start < end) {
                if(nums[start] + nums[end] == target){
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                }else if(nums[start] + nums[end] < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L15ThreeSum threeSum = new L15ThreeSum();

        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum.threeSum(new int[]{1,-1,-1,0}));
        System.out.println(threeSum.threeSum(new int[]{-2, 0, 0, 2, 2}));

    }
}
