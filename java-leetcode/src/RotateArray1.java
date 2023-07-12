import java.util.Arrays;
// Rotate an array of n elements to the right by k
public class RotateArray1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArrayReverse(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateArrayReverse(int[] arr, int k) {
        k = k % arr.length;
        int i = 0, j = arr.length - k - 1;

        // first reverse the arr.length - k elements
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        // change j to arr.length - 1 and i = arr.length - k
        i = arr.length - k;
        j = arr.length - 1;

        // 2nd reverse the last k elements
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        // set i = 0 and j = arr.length - 1
        i = 0;
        j = arr.length - 1;
        // 3rd reverse the whole array
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}