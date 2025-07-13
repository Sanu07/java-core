package com.leetcode.seventyfive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsteroidCollision735 {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {5,10,-5, 2, 12});
        list.add(new int[] {8, -8});
        list.add(new int[] {10,2,-5});
        list.add(new int[] {-2,-1,1,2});
        list.add(new int[] {-2,-2,1,-2});
        list.add(new int[] {-2,-2,1,-1});
        list.add(new int[] {1,-2,-2,-2});

        for (int[] arr: list) {
            int[] asteroidedCollision = asteroidCollision(arr);
            System.out.println(Arrays.toString(asteroidedCollision));
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0 && !list.isEmpty() && list.get(list.size() - 1) > 0) {
                while (!list.isEmpty()) {
                    int lastElem = list.get(list.size() - 1);
                    if (lastElem >= 0 && lastElem <= -asteroids[i]) {
                        list.remove(list.size() - 1);
                        if (lastElem == -asteroids[i]) {
                            break;
                        }
                        if (list.isEmpty()) {
                            list.add(asteroids[i]);
                            break;
                        }
                    } else {
                        if (list.get(list.size() - 1) < 0) {
                            list.add(asteroids[i]);
                        }
                        break;
                    }
                }
            } else {
                list.add(asteroids[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
