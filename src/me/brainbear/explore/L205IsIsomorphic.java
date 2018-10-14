package me.brainbear.explore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L205IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars1.length; i++) {
            if (map.containsKey(chars1[i])) {
                if (!map.get(chars1[i]).equals(chars2[i])) {
                    return false;
                }
            } else {
                if(set.contains(chars2[i])){
                    return false;
                }
                map.put(chars1[i], chars2[i]);
                set.add(chars2[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        L205IsIsomorphic isIsomorphic = new L205IsIsomorphic();

        System.out.println(isIsomorphic.isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic.isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic.isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic.isIsomorphic("ab", "aa"));

    }
}
