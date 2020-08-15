import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> taskMap = new HashMap();
        int maxCount=0;
        int difference = 0;
        for(Character task : tasks)
        {
            int count = taskMap.getOrDefault(task, 0) + 1;
            taskMap.put(task, count);
            maxCount = Math.max(maxCount, count);
        }
        for(Map.Entry<Character, Integer> entry : taskMap.entrySet())
        {
            if(entry.getValue() == maxCount)difference++;
        }
        int number1 = (n+1)*(maxCount-1) +difference;
        int number2 = tasks.length;
        return Math.max(number1, number2);
    }
}