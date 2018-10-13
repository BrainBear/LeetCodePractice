package me.brainbear.explore;

public class L209MinSubArrayLen {


    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int i = 0, j = 0, sum = nums[0];
        int min = 0;
        while (j < nums.length) {
            if (sum < s) {
                if (j < nums.length - 1) {
                    sum += nums[++j];
                }else{
                    break;
                }
            } else {
                int count = j - i + 1;
                if (min == 0 || min > count) {
                    min = count;
                }
                sum -= nums[i++];
                if (i > j) {
                    return 1;
                }
            }
        }
        return min;
    }


    public static void main(String[] args) {
        L209MinSubArrayLen minSubArrayLen = new L209MinSubArrayLen();
        int[] nums = new int[]{10, 2, 3};
        int ret = minSubArrayLen.minSubArrayLen(6, nums);
        System.out.println(ret);
        nums = new int[]{2, 3, 1, 2, 4, 3};
        ret = minSubArrayLen.minSubArrayLen(7, nums);
        System.out.println(ret);
    }
}
