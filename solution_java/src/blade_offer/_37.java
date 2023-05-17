package blade_offer;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: sunmengjin
 * @create: _37.class  2022-09-05 10:17
 **/
public class _37 {
    public static void main(String[] args) {
        System.out.println(serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))));
        System.out.println(deserialize(serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))))));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public static String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        if ("None".equals(list.get(0))) {
            list.remove(0);
            return null;
        }

        return rdeserialize(list);
    }

    public static TreeNode rdeserialize(List<String> dataList) {
        if ("None".equals(dataList.get(0))) {
            dataList.remove(0);
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        treeNode.left = rdeserialize(dataList);
        treeNode.right = rdeserialize(dataList);

        return treeNode;
    }
}
