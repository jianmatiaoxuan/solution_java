package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode69.class 2022-08-21-22 22:04
 **/
public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        int index = -1, left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= x) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
