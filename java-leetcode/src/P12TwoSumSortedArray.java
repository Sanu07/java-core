import java.util.Arrays;

// Find index of 2 elements that sum up to the target value.
// array is sorted
public class P12TwoSumSortedArray {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 26;
        findTwoSum(arr, target);
    }

    private static void findTwoSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int sum = arr[i] + arr[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                System.out.println(Arrays.toString(new int[] {i + 1, j + 1}));
                return;
            }
        }
    }
}
