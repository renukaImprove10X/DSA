package course.recursion.trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null) return;
        if(root.left != null) helper(root.left, res); // checks are to avoid unnecessary calls
        if(root.right != null) helper(root.right, res);
        res.add(root.val);
    }
}
