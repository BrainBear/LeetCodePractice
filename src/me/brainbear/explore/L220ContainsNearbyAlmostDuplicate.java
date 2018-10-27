package me.brainbear.explore;

import java.util.TreeSet;

public class L220ContainsNearbyAlmostDuplicate {


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long ceiling = treeSet.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= (long) nums[i] + t) {
                return true;
            }

            treeSet.add((long) nums[i]);

            if (treeSet.size() > k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L220ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new L220ContainsNearbyAlmostDuplicate();

        System.out.println(containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(new int[]{0, 2147483647}, 1, 2147483647));
        System.out.println(containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(new int[]{-2147483648, -2147483647}, 3, 3));
    }
}
