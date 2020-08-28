import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for(int val : arr1)
            counts[val]++;
        int i = 0;
        for(int val : arr2){
            while(counts[val]>0)
            {
                arr1[i++] = val;
                counts[val]--;
            }
        }
        for(int val=0;val<counts.length;val++)
        {
            while(counts[val]>0)
            {
                arr1[i++] = val;
                counts[val]--;
            }
        }
        return arr1;
    }
}