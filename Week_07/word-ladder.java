import java.util.*;

class Solution {
    public class Tuple<T1, T2> {
        public T1 left;
        public T2 right;

        public Tuple(T1 t1, T2 t2) {
            left = t1;
            right = t2;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        int len = beginWord.length();
        for(String word : wordList)
        {
            for(int i=0; i<len; i++)
            {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> strs = map.getOrDefault(newWord, new ArrayList<String>());
                strs.add(word);
                map.put(newWord, strs);
            }
        }
        if(!wordList.contains(endWord))return 0;
        Queue<Tuple<String, Integer>> queue = new LinkedList<Tuple<String, Integer>>();
        queue.add(new Tuple(beginWord, 1));
        HashSet<String> visited = new HashSet<String>();
        visited.add(beginWord);
        while(!queue.isEmpty())
        {
            Tuple<String, Integer> tuple = queue.poll();
            String word = tuple.left;
            Integer level = tuple.right;
            for(int i=0; i<len; i++)
            {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                if(!map.containsKey(newWord))continue;
                for(String str : map.get(newWord))
                {
                    if(visited.contains(str))continue;
                    if(str.equals(endWord))return level+1;
                    queue.add(new Tuple(str, level+1));
                    visited.add(str);
                }
            }
        }
        return 0;
    }
}