package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author: sunmengjin
 * @create: LeetCode1470.class 2022-08-29-10 10:41
 **/
public class LeetCode1470 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

    public static int[] shuffle(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(nums[i]);
            list.add(nums[i + n]);
        }
        return list.stream().filter(Objects::nonNull).mapToInt(i -> i).toArray();
    }
}
