package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode1455.class 2022-08-21-22 22:25
 **/
public class LeetCode1455 {
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("hellohello hellohellohello", "ell"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        int index = -1;
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(searchWord)) {
                index = i + 1;
                return index;
            }
        }
        return index;
    }
}
