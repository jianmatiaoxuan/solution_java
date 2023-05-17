package leetcode;

/**
 * @Author sunmengjin
 * @Create LeetCode9.java 2023/1/28 15:04
 * @Description:
 */
public class LeetCode9 {
    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;
        int start = 0;
        int end = length - 1;

        while (start <= end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }

        return x == revertNum | x == revertNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1(121));
    }
}
