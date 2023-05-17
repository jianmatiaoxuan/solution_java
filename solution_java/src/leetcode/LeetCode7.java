package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode7.class 2022-08-27-20 20:32
 **/
public class LeetCode7 {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
