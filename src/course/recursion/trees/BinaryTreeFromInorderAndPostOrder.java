package course.recursion.trees;

import java.util.HashMap;

public class BinaryTreeFromInorderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = inorder.length;
        for(int i=0; i<s; i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, s-1, postorder, 0, s-1, map);
    }
    private TreeNode buildTreeHelper(int[] inorder, int inSt, int inEnd, int[] postorder, int postSt, int postEnd, HashMap<Integer, Integer> map){
        if(inSt > inEnd || postSt > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRootIdx = map.get(postorder[postEnd]);
        int numsInLeft = inRootIdx - inSt;
        root.left = buildTreeHelper(inorder, inSt, inRootIdx-1, postorder, postSt, postSt+numsInLeft-1, map);
        root.right =  buildTreeHelper(inorder, inRootIdx+1, inEnd, postorder, postSt+numsInLeft, postEnd-1, map);
        return root;
    }
}
