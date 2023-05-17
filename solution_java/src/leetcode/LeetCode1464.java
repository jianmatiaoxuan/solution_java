package leetcode;

import java.util.Arrays;

/**
 * @author: sunmengjin
 * @create: LeetCode1464.class 2022-08-26-16 16:09
 **/
public class LeetCode1464 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,7}));
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);

        int first = nums[nums.length - 1];
        int second = nums[nums.length - 2];

        return (first - 1) * (second - 1);
    }
}
