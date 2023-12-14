package course.recursion.trees.BST;

import java.util.Collections;
import java.util.List;

public class constructBTGivenPreorder {
    private TreeNode bstFromPreorderHelper(int[] preorder, int st, int end) {
        if(st > end) return null;
        TreeNode root = new TreeNode(preorder[st]);// this must be preorder[st] not preorder[0]
        int ind = st;
        for(ind = st;ind<=end; ind++){
            if(preorder[ind] > preorder[st]) break;
        }
//        int ind = Collections.binarySearch(List.of(preorder), root.val);
        root.left = bstFromPreorderHelper(preorder, st+1, ind-1);
        root.right = bstFromPreorderHelper(preorder, ind, end);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, 0, preorder.length-1);
    }
}
