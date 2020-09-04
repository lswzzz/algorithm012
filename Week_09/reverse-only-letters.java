import java.util.*;

class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int i=0;
        int j=n-1;
        while(i<n&&i<j)
        {
            while(i<j&&!isLetter(cs[i])) i++;
            while(j>i&&!isLetter(cs[j])) j--;
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(cs);
    }

    public boolean isLetter(char c)
    {
        return (c>='A'&&c<='Z') || (c>='a'&&c<='z');
    }
}