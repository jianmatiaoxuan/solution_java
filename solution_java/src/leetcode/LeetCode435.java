package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: sunmengjin
 * @create: LeetCode435.class  2022-09-03 13:20
 **/
public class LeetCode435 {
    public static void main(String[] args) {
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
//        System.out.println(eraseOverlapIntervals2(new int[][]{{1, 2}, {2, 3}}));
        System.out.println(eraseOverlapIntervals2(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return len - dp[len - 1];
    }

    public static int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
