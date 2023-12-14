package course.recursion.trees;

import java.util.*;

public class FindlargestvalueineachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int[] temp = new int[s];
            for(int i=0; i<s; i++){
                TreeNode front = q.remove();
                temp[i] = front.val;
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            Arrays.sort(temp);
            res.add(temp[s-1]);
        }
        return res;
    }
}
