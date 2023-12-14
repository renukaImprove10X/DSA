package course.recursion.trees.BST;

import course.recursion.trees.TreeNode;

public class insertInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val); // nodes are zero
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
