import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++)
        {
            int complete = target - nums[i];
            if(map.containsKey(complete))
            {
                return new int[]{map.get(complete), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}