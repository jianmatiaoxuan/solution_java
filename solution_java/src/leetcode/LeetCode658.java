package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sunmengjin
 * @create: LeetCode658.class 2022-08-25-14 14:16
 **/
public class LeetCode658 {
    public static void main(String[] args) {
        System.out.println(findClosestElements2(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = 0;
        int temp = Math.abs(arr[0] - x);
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < temp) {
                temp = Math.abs(arr[i] - x);
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>(Collections.singletonList(arr[index]));
        int left = index - 1, right = index + 1;
        while (k > 1) {
            if (left >= 0 && right < arr.length) {
                if (Math.abs(x - arr[left]) > Math.abs(arr[right] - x)) {
                    res.add(arr[right]);
                    right++;
                } else {
                    res.add(arr[left]);
                    left--;
                }
            } else if (left >= 0 && right >= arr.length) {
                res.add(arr[left]);
                left--;
            } else if (left < 0 && right < arr.length) {
                res.add(arr[right]);
                right++;
            } else {
                break;
            }
            k--;
        }

        return res.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }

        return list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - x) != Math.abs(o2 - x)) {
                    return Math.abs(o1 - x) - Math.abs(o2 - x);
                }
                return o1 - o2;
            }
        }).collect(Collectors.toList()).subList(0, k).stream().sorted().collect(Collectors.toList());
    }
}
