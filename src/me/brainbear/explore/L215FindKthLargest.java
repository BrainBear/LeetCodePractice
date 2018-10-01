package me.brainbear.explore;

import java.util.Arrays;
import java.util.Random;

public class L215FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length);
    }


    private static Random random = new Random();


    private int findKthLargest(int[] nums, int k, int start, int end) {
        int p = partition(nums, start, end);

        if (k < nums.length - p) {
            return findKthLargest(nums, k, p + 1, end);
        } else if (k > nums.length - p) {
            return findKthLargest(nums, k, start, p);
        } else {
            return nums[p];
        }
    }

    private int partition(int[] nums, int start, int end) {

        int i = random.nextInt(end - start) + start;

        int temp;
        if (i != start) {
            swap(nums, i, start);
        }
        i = start + 1;
        int j = end - 1;

        while (true) {
            while (i < end && nums[i] < nums[start]) {
                i++;
            }
            while (j >= start && nums[j] > nums[start]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, start, j);
        return j;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        L215FindKthLargest findKthLargest = new L215FindKthLargest();

        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 4};
        System.out.println(findKthLargest.findKthLargest(nums, 1));
    }
}
