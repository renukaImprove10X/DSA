package course.recursion.trees;

import java.util.*;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> curr = new ArrayList<>();
            int s = q.size();
            for(int i=0; i<s;i++){
                TreeNode front = q.remove();
                curr.add(front.val);
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            res.add(curr);
        }
        Collections.reverse(res);
        return res;
    }
}
