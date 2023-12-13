package course.recursion.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0; i<s; i++){
                TreeNode front = q.remove();
                invert(front);
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
        }
        return root;
    }

    private void invert(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }
}
