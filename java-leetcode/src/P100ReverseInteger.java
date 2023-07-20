public class P100ReverseInteger {
    public static void main(String[] args) {
        int x = -123;

        int temp = Math.abs(x);
        int result = 0;
        while (temp != 0) {
            int rem = temp % 10;
            result = result * 10 + rem;
            temp = temp / 10;
        }
        System.out.println(x < 0 ? -1 * result : result);
    }
}
