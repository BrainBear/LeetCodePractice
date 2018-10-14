package me.brainbear.explore;

public class L242IsAnagram {
    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int[] temp1 = new int[26];
        int[] temp2 = new int[26];

        for (int i = 0; i < chars1.length; i++) {
            temp1[chars1[i] - 'a']++;
        }

        for (int i = 0; i < chars2.length; i++) {
            temp2[chars2[i] - 'a']++;
        }

        int i = 0;
        for (; i < 26; i++) {
            if (temp1[i] != temp2[i])
                break;
        }
        if (i == 26) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        L242IsAnagram isAnagram = new L242IsAnagram();


        System.out.println(isAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram.isAnagram("rat", "car"));
    }
}
