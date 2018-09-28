package me.brainbear.explore;

import java.util.Arrays;

public class L75SortColors {

    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
            }
        }

        int index = 0;
        while (zeroCount-- > 0) {
            nums[index++] = 0;
        }
        while (oneCount-- > 0) {
            nums[index++] = 1;
        }
        while (twoCount-- > 0) {
            nums[index++] = 2;
        }
    }

    public void sortColors1(int[] nums) {
        int zeroIndex = -1;
        int twoIndex = nums.length;

        int i = 0;
        while (i < twoIndex) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                zeroIndex++;
                nums[i++] = nums[zeroIndex];
                nums[zeroIndex] = 0;
            } else if (nums[i] == 2) {
                twoIndex--;
                nums[i] = nums[twoIndex];
                nums[twoIndex] = 2;
            }
        }
    }

    public static void main(String[] args) {
        L75SortColors sortColors = new L75SortColors();
        int[] nums = new int[]{0, 1, 0, 2, 0, 1, 2};

        System.out.println(Arrays.toString(nums));
        sortColors.sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
