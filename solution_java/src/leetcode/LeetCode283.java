package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode283.class 2022-08-29-16 16:00
 **/
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[index] = 0;
        }
    }
}
