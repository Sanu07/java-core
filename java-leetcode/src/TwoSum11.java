import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum11 {

    public static void main(String[] args) {
        int[] arr = {2, 6, 11, 7};
        int target = 13;
        final int[] twoSum = twoSum(arr, target);
        System.out.println(Arrays.toString(twoSum));
    }

    private static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[] {map.get(target - arr[i]) + 1, i + 1};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[] {};
    }
}
