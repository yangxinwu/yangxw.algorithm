package yangxinwu.algorithm;

//
//剑指 Offer 32 - II. 从上到下打印二叉树 II
//        从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
//
//
//        例如:
//        给定二叉树: [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回其层次遍历结果：
//
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();


        if (root != null )
            queue.add(root);

        while (!queue.isEmpty()){

            List<Integer> temp = new ArrayList<>();

            int n = queue.size();

            for (; n > 0 ; n--) {

                TreeNode node = queue.poll();
                temp.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }

           res.add(temp);

        }



    return res;


    }


}
