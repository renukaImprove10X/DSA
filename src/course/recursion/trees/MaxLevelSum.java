package course.recursion.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 0;
        if(root == null) return maxLevel;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        int prev = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int s = q.size();
            int[] temp = new int[s];
            int sum = 0;
            for(int i=0; i<s; i++){
                TreeNode front = q.remove();
                sum += front.val;
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            if(sum > prev){
                maxLevel = level;
                prev = sum;
            }
            level++;
        }
        return maxLevel;
    }
}
