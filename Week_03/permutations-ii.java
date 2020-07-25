import java.util.*;

class Solution {
    List<List<Integer>> res;
    public void backtrack(LinkedList<Integer> stack, int[] nums, boolean[] used)
    {
        if(stack.size() >= nums.length)
        {
            res.add(new LinkedList<>(stack));
        }
        for(int i=0; i<nums.length; i++)
        {
            if(used[i])continue;
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1])continue;
            stack.add(nums[i]);
            used[i] = true;
            backtrack(stack, nums, used);
            stack.pollLast();
            used[i] = false;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new LinkedList<List<Integer>>();
        backtrack(new LinkedList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
}