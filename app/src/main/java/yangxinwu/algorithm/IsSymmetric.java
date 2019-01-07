package yangxinwu.algorithm;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

 时间复杂度：O(n)。因为我们遍历整个输入树一次，所以总的运行时间为 O(n)，其中 nn 是树中结点的总数。
 空间复杂度：递归调用的次数受树的高度限制。在最糟糕的情况下，树是线性的，其高度为 O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)。
 */

public class IsSymmetric {

    private boolean isSymmetric(TreeNode root){
        return isMonitor(root,root);
    }

    private boolean isMonitor(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && isMonitor(root1.left,root2.right) && isMonitor(root1.right,root2.left);

    }

}
