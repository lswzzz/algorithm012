import java.util.*;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        findCombinations(n, k, 1, new Stack<>());
        return result;
    }

    // p 可以声明成一个栈
    // i 的极限值满足： n - i + 1 = (k - pre.size())。
    // 【关键】n - i + 1 是闭区间 [i,n] 的长度。
    // k - pre.size() 是剩下还要寻找的数的个数。
    private void findCombinations(int n, int k, int index, Stack<Integer> p) {
        if (p.size() == k) {
            result.add(new ArrayList<>(p));
            return;
        }
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
            p.push(i);
            findCombinations(n, k, i + 1, p);
            p.pop();
        }
    }
}