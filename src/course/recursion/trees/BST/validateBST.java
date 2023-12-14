package course.recursion.trees.BST;

import course.recursion.trees.BST.TreeNode;

public class validateBST {
    private boolean helper(TreeNode root, long start, long end){
        if(root == null) return true;
        if(root.val <= start || root.val >= end) return false; // dont forget "OR"
        return helper(root.left, start, root.val) && helper(root.right, root.val, end);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE); // Must be long, bcz the int.min and int.max are also valid keyd
    }
}
