package mianshiti;

import java.util.Arrays;

/**
 * @author: sunmengjin
 * @create: _01_02 2022-09-27 9:16
 **/
public class _01_02 {
    public static boolean CheckPermutation(String s1, String s2) {
        String[] split1 = s1.split("");
        String[] split2 = s2.split("");

        Arrays.sort(split1);
        Arrays.sort(split2);

        return Arrays.equals(split1, split2);
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bca"));
    }
}
