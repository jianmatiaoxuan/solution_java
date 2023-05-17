package leetcode;

import leetcode.model.TreeNode;

import java.util.*;

/**
 * @author: sunmengjin
 * @create: LeetCode652.class  2022-09-05 09:45
 **/
public class LeetCode652 {
    static Map<String, TreeNode> map = new HashMap<>();
    static Set<TreeNode> set = new HashSet<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(set);
    }

    private static String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("(");
        sb.append(dfs(root.left));
        sb.append(")(");
        sb.append(dfs(root.right));
        sb.append(")");

        String toString = sb.toString();
        if (map.containsKey(toString)) {
            set.add(map.get(toString));
        } else {
            map.put(toString, root);
        }

        return toString;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicateSubtrees(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)))));
    }
}
