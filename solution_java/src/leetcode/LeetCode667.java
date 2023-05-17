package leetcode;

import java.util.Arrays;

/**
 * @author: sunmengjin
 * @create: LeetCode667.class  2022-09-08 10:33
 **/
public class LeetCode667 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(5, 3)));
    }
    public static int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; ++i) {
            answer[idx] = i;
            ++idx;
        }
        for (int i = n - k, j = n; i <= j; ++i, --j) {
            answer[idx] = i;
            ++idx;
            if (i != j) {
                answer[idx] = j;
                ++idx;
            }
        }
        return answer;
    }
}
