import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    public boolean isIsomorphicHelper(String s, String t){
        int n = s.length();
        Map<Character, Character> map = new HashMap<Character, Character>();
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)) return false;
            }else
            {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}