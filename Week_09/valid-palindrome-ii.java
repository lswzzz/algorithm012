import java.util.*;

class Solution {
    int count=0;
    public boolean validPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int i=0;
        int j=n-1;
        while(i<j)
        {
            if(cs[i]==cs[j]){
                i++;
                j--;
            }else
            {
                if(count==0)
                {
                    count++;
                    boolean result1 = validPalindrome(s.substring(i+1, j+1));
                    boolean result2 = validPalindrome(s.substring(i, j));
                    return  result1 || result2;
                }
                return false;
            }
        }
        return true;
    }
}