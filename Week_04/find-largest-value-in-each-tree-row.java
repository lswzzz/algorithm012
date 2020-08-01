import java.util.*;

class Solution {
    Map<Integer, Integer> map;
    public List<Integer> largestValues(TreeNode root) {
        map = new HashMap<Integer, Integer>();
        List<Integer> res = new LinkedList<>();
        if(root != null)
        {
            largestValues(root, 1);
        }
        int[] levels = new int[map.size()];
        for(Integer level : map.keySet())
        {
            levels[level-1] = map.get(level);
        }
        for(int i=0; i<levels.length; i++)
        {
            res.add(levels[i]);
        }
        return res;
    }
    
    public void largestValues(TreeNode root, int level)
    {
        if(!map.containsKey(level))
        {
            map.put(level, root.val);
        }
        int val = root.val;
        map.put(level, Math.max(root.val, map.get(level)));
        if(root.left != null)
        {
            largestValues(root.left, level+1);
        }
        if(root.right != null)
        {
            largestValues(root.right, level+1);
        }
    }
}