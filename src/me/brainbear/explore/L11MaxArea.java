package me.brainbear.explore;

public class L11MaxArea {

    public int maxArea(int[] height) {
        int maxArea = 0;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int area = getArea(height, i, j);
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

    private int getArea(int[] height, int i, int j) {
        if (height[i] < height[j]) {
            return height[i] * (j - i);
        } else {
            return height[j] * (j - i);
        }
    }

    public static void main(String[] args) {
        L11MaxArea maxArea = new L11MaxArea();

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea.maxArea(height));
    }
}
