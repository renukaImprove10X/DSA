package course.recursion.trees;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumberHelper(root, 0);
    }

    private int sumNumberHelper(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.left != null || root.right != null){
            return sumNumberHelper(root.left, (sum * 10) + root.val) +
                    sumNumberHelper(root.right, (sum*10) + root.val); // Dont forget , this must be sum*10
        }
        return sum*10 + root.val;
    }
}
