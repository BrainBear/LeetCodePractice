package me.brainbear.explore;

public class L3LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }


        int left = 0, right = -1;
        int maxLen = 0;
        int[] freq = new int[256];

        while (left < s.length()) {
            if (right + 1 < s.length() && freq[s.charAt(right + 1)] == 0) {
                freq[s.charAt(++right)]++;
            } else {
                freq[s.charAt(left++)]--;
            }

            maxLen = maxLen > right - left + 1 ? maxLen : right - left + 1;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        L3LengthOfLongestSubstring lengthOfLongestSubstring = new L3LengthOfLongestSubstring();

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
