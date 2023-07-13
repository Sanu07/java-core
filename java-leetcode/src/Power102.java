public class Power102 {
    public static void main(String[] args) {
        int x = 3;
        int n = 3;

        if (x == 0) {
            System.out.println(0);
            return;
        }

        if (n == 0) {
            System.out.println(1);
            return;
        }

        // Find x^n
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= x;
        }
        System.out.println(result);
    }
}
