import java.util.*;

class Solution {
    public class Tuple<T1, T2>
    {
        public T1 left;
        public T2 right;
        public Tuple(T1 t1, T2 t2)
        {
            left = t1;
            right = t2;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> allComboDict = new HashMap<String, List<String>>();
        int length = beginWord.length();
        wordList.forEach(word->{
            for(int i=0; i<length; i++)
            {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> transformation = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformation.add(word);
                allComboDict.put(newWord, transformation);
            }
        });
        Queue<Tuple<String, Integer>> queue = new LinkedList<>();
        queue.add(new Tuple(beginWord, 1));
        HashSet<String> visited = new HashSet<String>();
        visited.add(beginWord);
        while(!queue.isEmpty()){
            Tuple<String, Integer> node = queue.remove();
            String word = node.left;
            int level  = node.right;
            for(int i=0; i<length; i++)
            {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                for(String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>()))
                {
                    if(adjacentWord.equals(endWord))
                    {
                        return level+1;
                    }
                    if(!visited.contains(adjacentWord))
                    {
                        visited.add(adjacentWord);
                        queue.add(new Tuple(adjacentWord, level+1));
                    }
                }
            }
        }
        return 0;
    }
}