package me.brainbear.explore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();

        String[] strs = str.split(" ");

        if(chars.length != strs.length){
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (!map.get(chars[i]).equals(strs[i])) {
                    return false;
                }
            } else {
                if (set.contains(strs[i])) {
                    return false;
                }
                map.put(chars[i], strs[i]);
                set.add(strs[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        L290WordPattern wordPattern = new L290WordPattern();

        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern.wordPattern("jquery", "jquery"));

    }
}
