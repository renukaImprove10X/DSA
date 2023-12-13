package course.recursion.trees;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalHelper(root, res);
        return res;
    }

    private void preorderTraversalHelper(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        if(root.left != null) preorderTraversalHelper(root.left, res);
        if(root.right != null) preorderTraversalHelper(root.right, res);
    }
}
