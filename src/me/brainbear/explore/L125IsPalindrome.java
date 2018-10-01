package me.brainbear.explore;

public class L125IsPalindrome {

    public boolean isPalindrome(String s) {
        boolean ret = true;
        char[] chars = s.toLowerCase().toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            while (i < j && !isValidChar(chars[i])) i++;
            while (j > i && !isValidChar(chars[j])) j--;
            if (i > j) {
                break;
            }
            if (chars[i] != chars[j]) {
                ret = false;
                break;
            }
            i++;
            j--;
        }
        return ret;
    }


    private boolean isValidChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        L125IsPalindrome isPalindrome = new L125IsPalindrome();

        System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome.isPalindrome("race a car"));
        System.out.println(isPalindrome.isPalindrome(""));
        System.out.println(isPalindrome.isPalindrome("           "));
    }
}
