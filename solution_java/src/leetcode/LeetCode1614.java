package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author: sunmengjin
 * @create: LeetCode1614.class 2022-08-30-15 15:47
 **/
public class LeetCode1614 {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
    public static int maxDepth(String s) {
        Pattern pattern = Pattern.compile("[a-z0-9+-/\\*=]");
        String replaceAll = pattern.matcher(s).replaceAll("");

        Stack<Character> stack = new Stack<>();
        int count = 0;
        int resCount = 0;
        for (int i = 0; i < replaceAll.length(); i++) {
            if (replaceAll.charAt(i) == '(') {
                stack.push(')');
                count++;
            }else if (replaceAll.charAt(i) == '[') {
                stack.push(']');
                count++;
            }else if (replaceAll.charAt(i) == '{') {
                stack.push('}');
                count++;
            } else if (stack.peek() == replaceAll.charAt(i)) {
                if (resCount < count) {
                    resCount = count;
                }
                count--;
            }
        }
        return resCount;
    }
}
