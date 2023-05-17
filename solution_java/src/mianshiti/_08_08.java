package mianshiti;

import java.util.*;

/**
 * @author: sunmengjin
 * @create: _08_08.class 2022-08-30-17 17:12
 **/
public class _08_08 {
    static List<String> res = new ArrayList<>();

    public static String[] permutation(String S) {
        dfs(S.toCharArray(), 0);
        return res.toArray(new String[0]);
    }

    private static void dfs(char[] chars, int deep) {
        if (deep == chars.length) {
            res.add(new String(chars));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = deep; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                swap(chars, i, deep);
                dfs(chars, deep + 1);
                swap(chars, i, deep);
            }
        }
    }

    private static void swap(char[] chars, int index, int deep) {
        char temp = chars[index];
        chars[index] = chars[deep];
        chars[deep] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("qqe")));
    }
}
