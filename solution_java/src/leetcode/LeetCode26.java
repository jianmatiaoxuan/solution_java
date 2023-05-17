package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode26.class 2022-08-21-21 21:39
 **/
public class LeetCode26 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 3, 4}; // 输入数组
        int[] expectedNums = {1, 2, 3, 4}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println(k);
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
