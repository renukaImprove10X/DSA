package course.recursion.trees;

import java.util.HashMap;

public class BinaryTreeFromInorderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = inorder.length;
        for(int i=0; i<s; i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, s-1, inorder, 0, s-1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd, HashMap<Integer, Integer> map){
        if(preSt > preEnd || inSt > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preSt]);
        int inRootIdx = map.get(preorder[preSt]);
        int numsInLeft = inRootIdx-inSt;
        root.left = buildTreeHelper(preorder, preSt+1, preSt+numsInLeft, inorder, inSt, inRootIdx-1, map);
        root.right = buildTreeHelper(preorder, preSt+numsInLeft+1, preEnd, inorder, inRootIdx+1, inEnd, map);
        return root;
    }
}
