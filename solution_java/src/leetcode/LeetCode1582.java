package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: sunmengjin
 * @create: LeetCode1582.class  2022-09-04 12:21
 **/
public class LeetCode1582 {
    public static void main(String[] args) {
//        System.out.println(numSpecial(new int[][]{
//                {1, 0, 0},
//                {0, 0, 1},
//                {1, 0, 0}
//        }));
        System.out.println(numSpecial(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
    }

    public static int numSpecial(int[][] mat) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        int len = mat.length;
        int size = mat[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < size; j++) {
                if (mat[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            int xIndex = 0;
            while (xIndex < len) {
                if (xIndex == x) {
                    xIndex++;
                    continue;
                }
                if (mat[xIndex][y] == 1) {
                    break;
                }
                xIndex++;
            }

            int yIndex = 0;
            while (yIndex < size) {
                if (yIndex == y) {
                    yIndex++;
                    continue;
                }
                if (mat[x][yIndex] == 1) {
                    break;
                }
                yIndex++;
            }

            if (xIndex == len && yIndex == size) {
                count++;
            }
        }

        return count;
    }
}
