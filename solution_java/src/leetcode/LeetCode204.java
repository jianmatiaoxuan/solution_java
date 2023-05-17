package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode204.class 2022-08-21-21 21:19
 **/
public class LeetCode204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int count = 0;
        int[] arr = new int[n];

        for (int i = 2; i < n; i++) {
            if (arr[i] == 0) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        arr[j] = 1;
                    }
                }
            }
        }
        return count;
    }
}
