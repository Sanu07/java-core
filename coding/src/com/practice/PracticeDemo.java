package com.practice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PracticeDemo {
    public static void main(String[] args) {
        java8();
    }

    public static void java8() {
        List<Employee> employees = employees();

        Map<Integer, List<String>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(collect);
        {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            Integer thirdSmallest = numbers.stream().distinct().skip(2).limit(1).findFirst().get();
            System.out.println(thirdSmallest);
        }
        {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            Integer thirdSmallest = numbers.stream().distinct().sorted((a, b) -> b- a).skip(2).limit(1).findFirst().get();
            System.out.println(thirdSmallest);
        }
    }

    private static void checkNPE() {
        List<Employee> employees = List.of(new Employee(null, 1), new Employee(null, 2));
        Predicate<Employee> empPred = (employee -> employee.getId() > 0);
        Map<Integer, String> collect = new HashMap<>();
                employees.stream().filter(empPred).forEach(service -> {
                collect.put(service.getId(), service.getName());
        });
        System.out.println(collect);
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1; // carry calculation
            a = a ^ b; // sum without carry
            b = tmp; // carry shifted left
        }
        return a;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (!((s.charAt(i) == ')' && c == '(')
                        || (s.charAt(i) == '}' && c == '{')
                        || (s.charAt(i) == ']' && c == '['))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.putIfAbsent(s.charAt(i), 0);
            mapT.putIfAbsent(t.charAt(i), 0);

            int countS = mapS.get(s.charAt(i));
            int countT = mapT.get(t.charAt(i));

            mapS.put(s.charAt(i), ++countS);
            mapT.put(t.charAt(i), ++countT);
        }
        System.out.println(mapS);
        System.out.println(mapT);
        for (Map.Entry<Character, Integer> map2: mapS.entrySet()) {
            System.out.println(map2.getKey() + "-->" +map2.getValue() + "-->" + mapT.get(map2.getKey()));
            if (map2.getValue() != mapT.get(map2.getKey())) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String palCount = countPalindrome(s, i);
            if (palCount.length() > max) {
                max = palCount.length();
                res = palCount;
            }
        }
        return res;
    }

    private String countPalindrome(String s, int i) {
        int countEven = 1;
        int l = i;
        int r = i + 1;
        // even: bbbb
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l--) == s.charAt(r++)) {
                countEven++;
            } else {
                break;
            }
        }
        // for odd: bbb
        l = i - 1;
        r = i + 1;
        int countOdd = 1;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l--) == s.charAt(r++)) {
                countOdd++;
            } else {
                break;
            }
        }
        if (countEven > countOdd) {
            return s.substring((i - countEven + 2), (i + countEven));
        } else {
            return s.substring((i - countOdd + 1), (i + countOdd));
        }
    }

    public int countSubstrings(String s) {
        int ans = 0;
        // aaa
        // i = 0 -> (evenCount = 1 oddCount = 0)
        // i = 1 -> (evenCount = 1 oddCount = 1)
        // i = 2 -> (evenCount = 0 oddCount = 0)
        for (int i = 0; i < s.length(); i++) {
            int evenCount = countPalindrome(s, i, i + 1);
            int oddCount = countPalindrome(s, i - 1, i + 1);
            ans += evenCount + oddCount;
        }
        // s.length() accounts for every character
        return ans + s.length();
    }

    private int countPalindrome(String s, int l, int r) {
        int count = 0;
        while ((l >= 0 && r < s.length()) && s.charAt(l--) == s.charAt(r++)) {
            count++;
        }
        return count;
    }

    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l = 0, mx = 0;
        int n = s.length();
        for (int r = 0; r < n; ++r) {
            mx = Math.max(mx, ++cnt[s.charAt(r) - 'A']);
            if (r - l + 1 - mx > k) {
                --cnt[s.charAt(l++) - 'A'];
            }
        }
        return n - l;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);
        Collections.sort(intervalList, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] current = intervalList.get(0);

        for (int i = 1; i < intervalList.size(); i++) {
            int[] interval = intervalList.get(i);

            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                res.add(current);
                current = interval;
            }
        }

        res.add(current);
        return res.toArray(new int[res.size()][]);
    }

    public int minMeetingRooms(int[][] intervals) {
        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0, e = 0;
        int count = 0;
        int max = 0;
        while (s < start.length && e < end.length) {
            if (start[s] < end[e]) {
                count += 1;
                s += 1;
            } else {
                count -= 1;
                e += 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = 0; i < (right  - left); i++) {

                int topLeft = matrix[top][left + i];

                matrix[top][left + i] = matrix[bottom - i][left];

                matrix[bottom - i][left] = matrix[bottom][right - i];

                matrix[bottom][right - i] = matrix[top + i][right];

                matrix[top + i][right] = topLeft;

            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }

    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        List<Character> list = Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        char[] ch = s.toCharArray();
        while (l <= r) {
            while (!list.contains(ch[l]) && l <= r) {
                l++;
            }
            while (!list.contains(ch[r]) && r >= l) {
                r--;
            }
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
        return new String(ch);
    }

    private static List<Employee> employees() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setId(i + 1);
            employee.setName("emp-" + (i + 1));
            list.add(employee);
        }
        return list;
    }
}
