package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: sunmengjin
 * @create: LeetCode300.class  2022-09-03 13:43
 **/
public class LeetCode300 {
    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
//        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
