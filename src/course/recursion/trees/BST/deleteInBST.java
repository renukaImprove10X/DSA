package course.recursion.trees.BST;

public class deleteInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        // find key in the BST
        if(root == null) return root;
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        } else if(root.val > key){
            root.left = deleteNode(root.left, key);
        } else {
            // if no children or one child
            if(root.left == null){
                TreeNode temp = root.right;
                return temp;
            } else if(root.right == null){
                TreeNode temp = root.left;
                return temp;
            } else{
                // find the successor or predecessor
                // case successor
                // TreeNode succ = root.right;
                // while(succ != null && succ.left != null)
                //     succ = succ.left;
                // root.val = succ.val;
                // root.right = deleteNode(root.right, succ.val);
                // case pred
                TreeNode pred = root.left;
                while(pred != null && pred.right != null)
                    pred = pred.right;
                root.val = pred.val;
                root.left = deleteNode(root.left, pred.val);
            }
        }
        return root;
    }
}
