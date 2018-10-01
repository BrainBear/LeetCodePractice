package me.brainbear.explore;

import java.util.Arrays;

public class L88Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        int i = 0;
        int j = 0;
        int index = 0;

        while (index < m + n && i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                temp[index++] = nums1[i++];
            }else{
                temp[index++] = nums2[j++];
            }
        }

        if(i < m){
            System.arraycopy(nums1, i, temp, index, m - i);
        }
        if(j < n) {
            System.arraycopy(nums2, j, temp, index, n - j);
        }
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }


    public static void main(String[] args) {
        L88Merge merge = new L88Merge();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        merge.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
