package leetcode;

import leetcode.model.ListNode;
import leetcode.model.TreeNode;

import java.time.temporal.Temporal;

/**
 * @author: sunmengjin
 * @create: LeetCode998.class 2022-08-30-10 10:19
 **/
public class LeetCode998 {
    public static void main(String[] args) {
        System.out.println(insertIntoMaxTree(new TreeNode(4, new TreeNode(1), new TreeNode(3, new TreeNode(2), null)), 5).toString());
    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        return getNode(root, val);
    }

    private static TreeNode getNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            return new TreeNode(val, root, null);
        }
        root.right = getNode(root.right, val);

        return root;
    }
}
