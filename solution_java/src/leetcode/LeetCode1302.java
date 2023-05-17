package leetcode;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sunmengjin
 * @create: LeetCode1302.class 2022-08-17-18 18:30
 **/
public class LeetCode1302 {
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(deepestLeavesSum(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(7), null),
                        new TreeNode(5)),
                new TreeNode(3, null,
                        new TreeNode(6, null,
                                new TreeNode(8))))
        ));
    }

    public static int deepestLeavesSum(TreeNode root) {
        res = new ArrayList<>();
        getNodes(root, 0);
        return res.get(res.size() - 1).stream().reduce(Integer::sum).orElse(0);
    }

    private static void getNodes(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() <= depth) {
            res.add(new ArrayList<>());
        }
        if (root.left == null && root.right == null) {
            res.get(depth).add(root.val);
        }
        getNodes(root.left, depth + 1);
        getNodes(root.right, depth + 1);
    }
}
