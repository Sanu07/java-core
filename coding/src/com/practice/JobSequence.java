package com.practice;

import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequence {
    
    // Function to find the maximum profit job sequence
    public static int[] jobSequence(int n, Job[] jobs) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        // Create an array to keep track of free time slots
        boolean[] slot = new boolean[n];
        Arrays.fill(slot, false);
        
        // To store the sequence of jobs
        int[] jobSequence = new int[n];
        int totalProfit = 0;
        int jobCount = 0;

        // Traverse through all jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (starting from the latest possible slot)
            for (int j = Math.min(n - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true; // Mark this slot as filled
                    jobSequence[j] = jobs[i].id; // Store the job id in this slot
                    totalProfit += jobs[i].profit; // Add profit
                    jobCount++;
                    break;
                }
            }
        }

        System.out.println("Job Sequence: " + Arrays.toString(jobSequence));
        System.out.println("Total Profit: " + totalProfit);
        
        // Returning the total profit and job sequence
        return new int[] { totalProfit, jobCount };
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };
        
        int n = jobs.length;
        jobSequence(n, jobs);
    }
}
