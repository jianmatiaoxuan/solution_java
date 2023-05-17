package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: sunmengjin
 * @create: LeetCode1 2022-09-26 11:47
 **/
public class LeetCode1 {
    public static int[] twoSum(int[] nums, int target) {

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int right = nums.length - 1;
            int num = target - nums[i];
            while (right > i) {
                if (nums[right] != num) {
                    right--;
                } else {
                    resultList.add(i);
                    resultList.add(right);
                    return resultList.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
}
