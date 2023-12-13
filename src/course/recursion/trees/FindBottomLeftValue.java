package course.recursion.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0; i<s; i++){
                TreeNode front = q.remove();
                curr.add(front.val);
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            res.add(curr);
        }
        return res.get(res.size()-1).get(0);
    }
}
