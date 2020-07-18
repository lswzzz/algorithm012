import java.util.*;

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
      Queue<Node> queue = new LinkedList<Node>();
      if(root == null) return result;
      queue.add(root);
      while(!queue.isEmpty())
      {
          int size = queue.size();
          List<Integer> level = new ArrayList<Integer>();
          while(level.size() < size)
          {
              Node node = queue.remove();
              level.add(node.val);
              if(node.children!=null)
              {
                  queue.addAll(node.children);
              }
          }
          result.add(level);
      }
      return result;
  }
}