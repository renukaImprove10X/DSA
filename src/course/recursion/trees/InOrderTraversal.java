package course.recursion.trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalHelper(root, res);
        return res;
    }

    private void inorderTraversalHelper(TreeNode root, List<Integer> res){
        if(root == null) return;
        if(root.left != null) inorderTraversalHelper(root.left, res);
        res.add(root.val);
        if(root.right != null) inorderTraversalHelper(root.right, res);
    }
}
