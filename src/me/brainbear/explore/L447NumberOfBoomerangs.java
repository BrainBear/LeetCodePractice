package me.brainbear.explore;

import java.util.HashMap;
import java.util.Map;

public class L447NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int distance = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            for (Integer count : map.values()) {
                if (count >= 2) {
                    result += count * (count - 1);
                }
            }
            map.clear();
        }

        return result;
    }


    public static void main(String[] args) {
        L447NumberOfBoomerangs numberOfBoomerangs = new L447NumberOfBoomerangs();
//        int n = numberOfBoomerangs.numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}});
        int n = numberOfBoomerangs.numberOfBoomerangs(new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}});

        System.out.println(n);
    }
}
