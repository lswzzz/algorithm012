import java.util.*;

class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int i=0;
        while(i<n)
        {
            int start = i;
            while(i<n&&cs[i]!=' ') i++;
            if(i-1>start) reverse(cs, start, i-1);
            while(i<n&&cs[i]==' ')i++;
        }
        return String.valueOf(cs);
    }

    public void reverse(char[] cs, int start, int end)
    {
        if(start>=end)return;
        int len = end - start + 1;
        for(int i=0;i<len/2;i++)
        {
            char tmp = cs[start+i];
            cs[start+i] = cs[end-i];
            cs[end-i]=tmp;
        }
    }
}