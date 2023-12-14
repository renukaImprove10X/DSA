package course.recursion.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointers2 {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            Node prev = null;
            for(int i=0; i<s; i++){
                Node curr = q.remove();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(prev == null){
                    if(i == s-1) curr.next = null;
                    else prev = curr;
                } else {
                    prev.next = curr;
                    prev = curr;
                }
            }
        }
        return root;

    }
}
