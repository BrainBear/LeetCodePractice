package me.brainbear.explore;

public class L26RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int ret = 1;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                ret++;
                nums[++i] = nums[j];
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        L26RemoveDuplicates removeDuplicates = new L26RemoveDuplicates();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int ret = removeDuplicates.removeDuplicates(nums);

        System.out.println("ret:" + ret);
        for(int i = 0; i < ret; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
