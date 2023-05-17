package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode53.class 2022-08-27-20 20:18
 **/
public class LeetCode53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];

        for (int num : nums) {
            pre = Math.max(num, pre + num);
            res = Math.max(res, pre);
        }
        return res;
    }
}
