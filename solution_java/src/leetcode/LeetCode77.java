package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sunmengjin
 * @create: LeetCode77.class 2022-08-29-14 14:50
 **/
public class LeetCode77 {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        getCombine(n, k, 1, list);
        return res;
    }

    private static void getCombine(int n, int k, int start, List<Integer> list) {
        if (k == 0) {
            res.add(list);
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            getCombine(n, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
