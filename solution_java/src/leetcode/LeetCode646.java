package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: sunmengjin
 * @create: LeetCode646.class  2022-09-03 11:55
 **/
public class LeetCode646 {
    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
