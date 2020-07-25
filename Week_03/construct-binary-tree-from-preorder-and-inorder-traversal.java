import java.util.*;

class Solution {
    Map<Integer, Integer> rootMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<=0&&inorder.length<=0)return null;
        rootMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++)
        {
            rootMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd)
    {
        if(preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        int inRootIndex = rootMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftLength = inRootIndex - inStart;
        int rightLength = inEnd - inRootIndex;
        TreeNode left = buildTree(preorder, inorder, preStart+1, preStart + 1 + leftLength - 1, 
                inStart, inStart + leftLength - 1);
        TreeNode right = buildTree(preorder, inorder, preStart+1+leftLength-1+1, preEnd,
                inRootIndex+1, inRootIndex+1 + rightLength - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}