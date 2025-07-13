package com.companies.atlassian;

import java.util.*;

public class RankTeamByVotes {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[len]);
                map.get(c)[i]++;
            }
        }

        List<Character> teams = new ArrayList<>(map.keySet());
        Collections.sort(teams, (a, b) -> {
            for (int i = 0; i < len; i++) {
                if (map.get(a)[i] != map.get(b)[i])
                    return map.get(b)[i] - map.get(a)[i];
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (char c : teams) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new RankTeamByVotes().rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"});
        System.out.println(s);
    }
}
