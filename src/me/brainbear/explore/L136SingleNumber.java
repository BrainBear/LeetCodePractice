package me.brainbear.explore;

public class L136SingleNumber {
    public int singleNumber(int[] nums) {
        int ret = 0;

        for(int i = 0; i < nums.length; i++) {
            ret = ret ^ nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        L136SingleNumber singleNumber = new L136SingleNumber();
        int[] nums = new int[]{4,1,2,1,2};

        int ret = singleNumber.singleNumber(nums);

        System.out.println(ret);
    }
}
