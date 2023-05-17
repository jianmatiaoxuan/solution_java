package leetcode;

import java.util.*;

/**
 * @author: sunmengjin
 * @create: LeetCode1475.class 2022-09-01-13 13:46
 **/
public class LeetCode1475 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices2(new int[]{8, 4, 6, 2, 3})));
    }

    public static int[] finalPrices(int[] prices) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int index = i + 1;
            while (index < prices.length) {
                if (prices[i] >= prices[index]) {
                    break;
                }
                index++;
            }
            if (index < prices.length) {
                res.add(prices[i] - prices[index]);
            } else {
                res.add(prices[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] finalPrices2(int[] prices) {
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }

        return res;
    }
}
