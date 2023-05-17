package leetcode;

import leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: sunmengjin
 * @create: LeetCode662.class 2022-08-27-10 10:25
 **/
public class LeetCode662 {
    static Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        System.out.println(widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null), new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)))));
    }


    public static int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public static int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index);
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }
}
