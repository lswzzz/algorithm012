import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap();
        for(String s : strs)
        {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if(!map.containsKey(key))
            {
                List<String> list = new LinkedList<String>(){{add(s);}};
                map.put(key, list);
            }else
            {
                map.get(key).add(s);
            }
        }
        List<List<String>> res = new LinkedList<>();
        map.values().forEach(e -> res.add(e));
        return res;
    }
}