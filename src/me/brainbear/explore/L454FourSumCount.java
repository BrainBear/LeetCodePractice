package me.brainbear.explore;

import java.util.HashMap;
import java.util.Map;

public class L454FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            for (int j : B) {
                int temp = i + j;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        int ret = 0;
        for (int i : C) {
            for (int j : D) {
                int temp = i + j;
                if (map.containsKey(0 - temp)) {
                    ret += map.get(0 - temp);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        L454FourSumCount fourSumCount = new L454FourSumCount();
        System.out.println(fourSumCount.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println(fourSumCount.fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}));

    }
}
