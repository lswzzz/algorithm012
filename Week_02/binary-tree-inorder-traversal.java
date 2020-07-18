import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> result = new ArrayList<Integer>();
      if(root == null) return result;
        TreeNode pre = null;
      while(root != null)
      {
           if(root.left != null)
           {
             pre = root.left;
             TreeNode temp = pre;
             while(pre.right != null)
               {
                 pre = pre.right;
               }
               pre.right = root;
               root.left = null;
               root = temp;
           }else
           {
             result.add(root.val);
             root = root.right;
           }
      }

      return result;
    }
}