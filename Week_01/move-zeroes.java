import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null)return;
        int slow = 0;
        for(int fast = 0; fast<nums.length; fast++)
        {
            if(nums[fast] != 0)
            {
                int swap = nums[slow];
                nums[slow++] = nums[fast];
                nums[fast] = swap;
            }
        }
    }
}