package me.brainbear.explore;

import java.util.*;

public class L451FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Character, Integer> characterIntegerEntry = list.get(i);
            while (characterIntegerEntry.getValue() > 0) {
                sb.append((char) characterIntegerEntry.getKey());
                characterIntegerEntry.setValue(characterIntegerEntry.getValue() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L451FrequencySort frequencySort = new L451FrequencySort();

        System.out.println(frequencySort.frequencySort("tree"));
        System.out.println(frequencySort.frequencySort("cccaaa"));
        System.out.println(frequencySort.frequencySort("Aabb"));

    }
}
