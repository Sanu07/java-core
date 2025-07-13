package com.leetcode.assessment.jun7;

import java.util.*;

public class Transaction {


    public static void main(String[] args) {
        //String[] transactions = {"alice,20,800,mtv","alice,50,100,beijing"};
        String[][] transactions = {
                {"alice,20,800,mtv","alice,50,100,beijing"},
                {"alice,20,800,mtv","bob,50,1200,mtv"}
        };
        for (String[] s: transactions) {
            List<String> strings = new Transaction().invalidTransactions(s);
            System.out.println(strings);
        }

    }


    public List<String> invalidTransactions(String[] transactions) {

        List<Trans> trans = new ArrayList<>();
        for (String s: transactions) {
            String[] t = s.split(",");
            trans.add(new Trans(t[0], Integer.valueOf(t[1]), Integer.valueOf(t[2]), t[3]));
        }

        Collections.sort(trans);

        Map<String, List<Trans>> map = new HashMap<>();

        for (Trans t1: trans) {
            map.computeIfAbsent(t1.name, k -> new ArrayList<>()).add(t1);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, List<Trans>> m2: map.entrySet()) {
            List<Trans> t3 = m2.getValue();

            if (t3.size() == 1) {
                Trans t5 = t3.get(0);
                if (t5.amount > 1000) {
                    result.add(t5.name + "," + t5.time + "," + t5.amount + "," + t5.city);
                }
            }
            for (int i = 1; i < t3.size(); i++) {
                Trans t5 = t3.get(i);
                Trans t6 = t3.get(i - 1);
                if (t5.amount > 1000) {
                    result.add(t5.name + "," + t5.time + "," + t5.amount + "," + t5.city);
                }
                if (t6.amount > 1000) {
                    result.add(t6.name + "," + t6.time + "," + t6.amount + "," + t6.city);
                }

                if (t5.amount > 1000 || t6.amount > 1000) {
                    continue;
                }

                if (t6.time - t5.time <= 60 && !t5.city.equals(t6.city)) {
                    result.add(t5.name + "," + t5.time + "," + t5.amount + "," + t5.city);
                    result.add(t6.name + "," + t6.time + "," + t6.amount + "," + t6.city);
                }
            }

        }
        return result;
    }

    public static class Trans implements Comparable<Trans> {
        String name;
        int time;
        int amount;
        String city;

        public Trans(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        public int compareTo(Trans that) {
            return this.time - that.time;
        }
    }
}
