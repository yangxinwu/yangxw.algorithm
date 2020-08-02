package yangxinwu.algorithm;



//翻转一棵二叉树。
//
//        示例：
//
//        输入：
//
//        4
//        /   \
//        2     7
//        / \   / \
//        1   3 6   9
//        输出：
//
//        4
//        /   \
//        7     2
//        / \   / \
//        9   6 3   1
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/invert-binary-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {


        if (root == null) return null;


         Queue<TreeNode> queue = new LinkedList<>();

         queue.add(root);


         while (!queue.isEmpty()){
             TreeNode temp;
             TreeNode node = queue.poll();
             temp = node.right;
             node.right = node.left;
             node.left = temp;

             if (node.left != null) queue.add(node.left);
             if (node.right != null) queue.add(node.right);


         }


         return root;
    }
}
