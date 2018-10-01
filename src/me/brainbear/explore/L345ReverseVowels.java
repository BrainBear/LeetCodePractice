package me.brainbear.explore;

public class L345ReverseVowels {

    public String reverseVowels(String s) {
        if (null == s) return null;

        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            while (i < j && !isVowels(chars[i])) i++;
            while (j > i && !isVowels(chars[j])) j--;

            if (i > j) {
                break;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }
        return new String(chars);
    }


    private boolean isVowels(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' ||
                c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }


    public static void main(String[] args) {
        L345ReverseVowels reverseVowels = new L345ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("leetcode"));
    }
}
