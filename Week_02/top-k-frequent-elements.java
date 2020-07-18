import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2) ->
            map.get(n1) - map.get(n2)
        );
        for(int n : map.keySet())
        {
            heap.add(n);
            if(heap.size() > k)
            {
                heap.poll();
            }
        }
        List<Integer> top = new LinkedList<Integer>();
        while(!heap.isEmpty())
        {
            top.add(heap.poll());
        }
        Collections.reverse(top);
        int[] topK = new int[top.size()];
        for(int i=0; i<topK.length;i++)
        {
            topK[i] = top.get(i);
        }
        return topK;
    }
}