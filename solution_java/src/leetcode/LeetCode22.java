package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sunmengjin
 * @create: LeetCode22.class 2022-08-26-17 17:41
 **/
public class LeetCode22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[n * 2], 0, result);
        return result;
    }

    private static void generateAll(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            if (validArr(chars)) {
                result.add(new String(chars));
            }
        } else {
            chars[index] = '(';
            generateAll(chars, index + 1, result);
            chars[index] = ')';
            generateAll(chars, index + 1, result);
        }
    }

    private static boolean validArr(char[] chars) {
        int count = 0;
        for (char c : chars) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

}
