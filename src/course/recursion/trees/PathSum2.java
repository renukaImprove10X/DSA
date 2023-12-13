package course.recursion.trees;


import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        pathSumUtil(root, targetSum, curr, res);
        return res;
    }

    private void pathSumUtil(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> res) {
        if (root == null) return;
        curr.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) res.add(new ArrayList<>(curr));
        if (root.left != null) pathSumUtil(root.left, targetSum - root.val, curr, res);
        if (root.right != null) pathSumUtil(root.right, targetSum - root.val, curr, res);
        curr.remove(curr.size() - 1);
    }

}
