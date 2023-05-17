package leetcode;

import java.util.Arrays;

/**
 * @author: sunmengjin
 * @create: LeetCode60.class 2022-08-24-15 15:27
 **/
public class LeetCode60 {
    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        for (int i = 0; i < target.length - 1; i++) {
            int targetInt = target[i];

            for (int j = i; j < arr.length; j++) {
                if (arr[j] != targetInt) {
                    continue;
                }
                int left = i, right = j;
                while (left < right) {
                    int temp = arr[right];
                    arr[right] = arr[left];
                    arr[left] = temp;
                    left++;
                    right--;
                }
            }
        }

        return Arrays.equals(target, arr);
    }
}
