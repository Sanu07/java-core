import java.util.HashSet;
import java.util.Set;

public class P4WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("lee");
        dict.add("");
        dict.add("t");
        dict.add("code");
        final boolean hasSegments = wordBreak(0, s, dict);
        System.out.println(hasSegments);
    }

    public static boolean wordBreak(int start, String s, Set<String> dict) {

        if (s.length() == start) {
            return true;
        }

        for (String a: dict) {
            if (a.isEmpty()) {
                continue;
            }

            int len = a.length();
            int end = len + start;

            if (end > s.length()) {
                continue;
            }

            if (s.substring(start, end).equals(a)) {
                if (wordBreak(end, s, dict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
