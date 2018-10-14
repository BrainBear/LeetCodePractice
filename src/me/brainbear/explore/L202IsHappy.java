package me.brainbear.explore;

import java.util.HashSet;
import java.util.Set;

public class L202IsHappy {
    private Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        return isHappy(true, n);
    }

    private boolean isHappy(boolean clear, int n) {
        if (clear) {
            set.clear();
        }
        set.add(n);
        int temp = cal(n);
        if (temp == 1) {
            return true;
        } else if (set.contains(temp)) {
            return false;
        } else {
            return isHappy(false, temp);
        }
    }

    private int cal(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += Math.pow(temp, 2);
            n /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        L202IsHappy isHappy = new L202IsHappy();

        System.out.println(isHappy.isHappy(19));
        System.out.println(isHappy.isHappy(13));
        System.out.println(isHappy.isHappy(28));
        System.out.println(isHappy.isHappy(2));
    }
}
