import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    List<Integer> result = new ArrayList<Integer>();
    if(root == null)return result;
    TreeNode node = root;
    list.add(root);
    while(!list.isEmpty())
    {
      node = list.removeLast();
      result.add(node.val);
      if(node.right != null)
      {
        list.add(node.right);
      }
      if(node.left != null)
      {
        list.add(node.left);
      }
    }
    return result;
    }
}