import java.util.*;

class Solution {
     public List<List<Integer>> result = new LinkedList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<Integer>());
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> stack)
    {
        if(stack.size() == nums.length)
        {
            result.add(new LinkedList<>(stack));
        }

        for(int i=0; i<nums.length; i++)
        {
            if(stack.contains(nums[i]))continue;
            stack.add(nums[i]);
            backtrack(nums, stack);
            stack.removeLast();
        }
    }
}