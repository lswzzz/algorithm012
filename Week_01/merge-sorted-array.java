import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        System.arraycopy(nums1, 0, nums, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while(p1 < m && p2 < n)
        {
            nums1[p++] = nums[p1] < nums2[p2] ? nums[p1++] : nums2[p2++];
        }
        if(p1 < m)
        {
            System.arraycopy(nums, p1, nums1, p, m - p1);
        }
        if(p2 < n)
        {
            System.arraycopy(nums2, p2, nums1, p, n - p2);
        }
    }
}