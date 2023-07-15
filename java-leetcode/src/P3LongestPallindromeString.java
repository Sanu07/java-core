public class P3LongestPallindromeString {
    public static void main(String[] args) {

        String str = "dabcba";
        if (str.isEmpty()) {
            System.out.println("");
            return;
        }

        if (str.length() == 1) {
            System.out.println(str);
            return;
        }

        int longest = 0;
        String longestStr = null;

        for (int i = 0; i < str.length(); i++) {
            String temp = helper(str, i, i);
            if (temp.length() > longest) {
                longestStr = temp;
                longest = temp.length();
            }
        }
        System.out.println(longestStr);
    }

    private static String helper(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        return str.substring(begin + 1, end);
    }
}
