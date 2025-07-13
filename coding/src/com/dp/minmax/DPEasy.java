package com.dp.minmax;

public class DPEasy {

    public static void main(String[] args) {
        DPEasy dpEasy = new DPEasy();

        // dpEasy.lcs();

        dpEasy.lis();
    }

    // Longest Common Subsequence (LCS)
    // Input: s1 = “ABC”, s2 = “ACD”
    //Output: 2
    //Explanation: The longest subsequence which is present in both strings is “AC”.
    private void lcs() {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lcs(s1, s2, 0, 0));
    }

    private int lcs(String s1, String s2, int m, int n) {
        if (m == s1.length() || n == s2.length()) {
            return 0;
        }
        if (s1.charAt(m) == s2.charAt(n)) {
            return 1 + lcs(s1, s2, m + 1, n + 1);
        }
        return Math.max(lcs(s1, s2, m + 1, n), lcs(s1, s2, m, n + 1));
    }


    // Input: arr[] = [3, 10, 2, 1, 20]
    // Output: 3
    // Explanation: The longest increasing subsequence is 3, 10, 20
    private void lis() {
        int[] arr = {3, 10, 2, 1, 20};
        int len = lis(arr, 0, -1);
        System.out.println(len);
    }

    private int lis(int[] arr, int index, int prevIndex) {
        if (index == arr.length) {
            return 0;
        }
        int noTake = lis(arr, index + 1, prevIndex);
        int take = 0;
        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + lis(arr, index + 1, index);
        }
        return Math.max(take, noTake);
    }


}
