import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct=  t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return String.valueOf(cs).equals(String.valueOf(ct));
    }
}