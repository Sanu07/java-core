import java.util.List;
import java.util.UUID;

public class LongestPallindromeString3 {
    public static void main(String[] args) {

        test();

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

    private static void test() {
        List<String> list = List.of("Analysis", "Application", "Comprehension", "Evaluation", "Synthesis", "Understanding", "Other");
        List<String> list2 = List.of("Advanced", "Beginner", "Intermediate");
        List<String> list3 = List.of("CheggMate", "QA", "SQNA");
        List<String> list4 = List.of("Image Only", "Text Only", "Text with Image");
        List<String> list5 = List.of("SME", "Student", "Teacher");
        List<String> list6 = List.of("AI", "SME", "Teacher");
        list6.forEach(e -> {
            String lowerValue = e.toLowerCase().replaceAll("\\s", "-");
            System.out.print(e + "    " + lowerValue + "    " + UUID.nameUUIDFromBytes(lowerValue.getBytes()));
            System.out.println();
        });
    }

    private static String helper(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        return str.substring(begin + 1, end);
    }
}
