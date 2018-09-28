package me.brainbear.explore;

import java.util.Arrays;

public class L27RemoveElement {
    public int removeElement(int[] nums, int val) {

        int ret = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                if(i != j){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                ret++;
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        L27RemoveElement removeElement = new L27RemoveElement();
        int[] nums = new int[]{0, 1, 0, 2, 0, 1, 2};

        System.out.println(Arrays.toString(nums));
        int ret = removeElement.removeElement(nums, 1);
        System.out.println("ret:" + ret + " " + Arrays.toString(nums));
    }

}
