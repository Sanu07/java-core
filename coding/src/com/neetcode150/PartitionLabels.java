package com.neetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int j = 0;
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            j = Math.max(j, map.get(s.charAt(i)));
            while (i <= j) {
                j = Math.max(j, map.get(s.charAt(i)));
                i++;
                count++;
            }
            list.add(count);
        }
        return list;
    }

    public static void main(String[] args) {
        PartitionLabels labels = new PartitionLabels();
        List<Integer> list = labels.partitionLabels("ababcc");
        System.out.println(list);
    }
}