import java.util.*;

class Solution {
    Map<String, Integer> wordId;
    ArrayList<String> idWord;
    ArrayList<Integer>[] edges;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordId = new HashMap<>();
        idWord = new ArrayList<>();
        int id = 0;
        for(String word : wordList)
        {
            if(!wordId.containsKey(word))
            {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        if(!wordId.containsKey(endWord))
        {
            return new ArrayList<>();
        }
        if(!wordId.containsKey(beginWord))
        {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }
        edges = new ArrayList[idWord.size()];
        for(int i=0; i<edges.length;i++)
        {
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<idWord.size(); i++)
        {
            for(int j=i+1; j<idWord.size(); j++)
            {
                if(transformCheck(idWord.get(i), idWord.get(j)))
                {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        int dest = wordId.get(endWord);
        List<List<String>> res = new ArrayList<>();
        int[] cost = new int[id];
        for(int i=0; i<id; i++)
        {
            cost[i] = Integer.MAX_VALUE;
        }
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;
        
        while(!q.isEmpty())
        {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size()-1);
            if(last == dest)
            {
                ArrayList<String> tmp = new ArrayList<>();
                for(int index: now)
                {
                    tmp.add(idWord.get(index));
                }
                res.add(tmp);
            }else
            {
                for(int i=0; i<edges[last].size(); i++)
                {
                    int to = edges[last].get(i);
                    if(cost[last] + 1 <= cost[to])
                    {
                        cost[to] = cost[last] + 1;
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    
    boolean transformCheck(String str1, String str2)
    {
        int diff = 0;
        for(int i=0; i<str1.length(); i++)
        {
            if(str1.charAt(i) != str2.charAt(i))if(++diff>1)break;
        }
        return diff == 1;
    }
}