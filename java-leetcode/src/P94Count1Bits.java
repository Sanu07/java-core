public class P94Count1Bits {
    public static void main(String[] args) {
        // int n = 11; // 1101
        int n = 6; // 011
        int count = 0;
        for (int i = 1; i < 33; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
