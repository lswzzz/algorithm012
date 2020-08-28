import java.util.*;

class Solution {
    void merge(int[] arr, int start, int mid, int end)
    {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++)
            L[i] = arr[start+i];
        for(int j=0;j<n2;j++)
            R[j] = arr[mid+1+j];
        int i=0, j=0;
        for(int k=start;k<=end;k++)
        {
            if(j>=n2||(i<n1&&L[i]<=R[j]))
                arr[k] = L[i++];
            else
                arr[k] = R[j++];
        }
    }

    int mergesort_and_count(int[] arr, int start, int end)
    {
        if(start>=end)return 0;
        int mid = (start+end)/2;
        int count = mergesort_and_count(arr, start, mid) + mergesort_and_count(arr, mid+1, end);
        int j = mid + 1;
        for(int i=start;i<=mid;i++)
        {
            while(j<=end&&arr[i]>(long)arr[j]*2)j++;
            count+= j - (mid + 1);
        }
        merge(arr, start, mid, end);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergesort_and_count(nums, 0, nums.length-1);
    }
}