package me.brainbear.explore;

import java.util.*;

public class L349Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> ret = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                ret.add(nums2[i]);
            }
        }

        int[] array = new int[ret.size()];
        int i = 0;
        Iterator<Integer> iterator = ret.iterator();
        while (iterator.hasNext()){
            array[i++] = iterator.next();
        }
        return array;
    }

    public static void main(String[] args) {
        L349Intersection intersection = new L349Intersection();


        System.out.println(Arrays.toString(intersection.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
