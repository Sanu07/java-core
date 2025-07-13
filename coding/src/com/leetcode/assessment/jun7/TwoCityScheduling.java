package com.leetcode.assessment.jun7;

import java.util.Arrays;

public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][] costs = {
                {10,20},
                {30,200},
                {400,50},
                {30,20}
        };
        int res = new TwoCityScheduling().twoCitySchedCost(costs);
        System.out.println(res);
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int n = costs.length / 2;
        int totalCost = 0;

        for (int i = 0; i<n; i++){
            totalCost += costs[i][0];
        }

        for(int i = n; i<2*n; i++){
            totalCost += costs[i][1];
        }
        return totalCost;
    }
}
