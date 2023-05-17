package leetcode;

import java.util.regex.Pattern;

/**
 * @Author sunmengjin
 * @Create LeetCode2315.java 2023/1/29 11:01
 * @Description:
 */
public class LeetCode2315 {
    public static int countAsterisks(String s) {
        int count = 0;
        String[] split = s.split("\\|");
        for (int i = 0; i < split.length; i += 2) {
            count += split[i].replaceAll("[^*]", "").length();
        }
        return count;
    }

    public static int countAsterisks1(String s) {
        boolean valid = true;
        int count = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '|') {
                valid = !valid;
            } else if (c == '*' && valid) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countAsterisks1("\"yo|uar|e**|b|e***au|tifu|l"));
    }
}
