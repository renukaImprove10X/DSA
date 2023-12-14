package course.recursion.trees;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        boolean even = true;
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i=0; i<s; i++){
                TreeNode front = q.remove();
                int temp = front.val;
                if(even){
                    // all odd nos in inc order
                    if(temp % 2 == 0 || temp <= prev) return false; // OR
                } else {
                    // all even nos in dec order
                    if(temp % 2 == 1 || temp >= prev) return false; //OR
                }
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
                prev = temp;
            }
            even = !even;
        }
        return true;
    }
}
