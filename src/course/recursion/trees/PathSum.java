package course.recursion.trees;

class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == targetSum) return true;
        boolean leftSum = false;
        boolean rightSum = false;
        if(root.left != null) {
            leftSum = hasPathSum(root.left, targetSum - root.val);
        }
        if(root.right != null) {
            rightSum = hasPathSum(root.right, targetSum - root.val);
        }
        return leftSum || rightSum;
    }
}
