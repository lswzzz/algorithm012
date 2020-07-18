import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       for(int i=0; i<nums.length; i++)
       {
           int sum = target - nums[i];
           if(map.containsKey(sum))
           {
               return new int[]{i, map.get(sum)};
           }
           map.put(nums[i], i);
       }
       return null;
    }
}