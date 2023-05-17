package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode5.class 2022-08-24-16 16:01
 **/
public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String oneString = getLongString(i, i, s);
            String twoString = getLongString(i, i + 1, s);
            if (oneString.length() > twoString.length()) {
                if (oneString.length() > res.length()) {
                    res = oneString;
                }
            } else {
                if (twoString.length() > res.length()) {
                    res = twoString;
                }
            }
        }
        return res;
    }

    private static String getLongString(int slow, int fast, String str) {
        boolean flag = (slow < 0 || fast >= str.length()) || str.charAt(slow) != str.charAt(fast);
        if (flag) {
            return "";
        }
        while (slow >= 0 && fast < str.length()) {
            if (str.charAt(slow) == str.charAt(fast)) {
                slow--;
                fast++;
            } else {
                return str.substring(slow + 1, fast);
            }
        }

        return str.substring(slow + 1, fast);
    }
}
