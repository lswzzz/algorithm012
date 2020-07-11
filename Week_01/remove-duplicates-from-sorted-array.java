import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 1; fast<nums.length; fast++)
        {
            if(nums[fast] != nums[slow])
            {
                int tmp = nums[++slow];
                nums[slow] = nums[fast];
                nums[fast] = nums[slow];
            }
        }
        return slow + 1;
    }
}