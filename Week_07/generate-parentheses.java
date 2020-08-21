import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n<=0)return list;
        backtrack(list, 0, 0, n, "");
        return list;
    }
    
    public void backtrack(List<String> list, int left, int right, int max, String combination)
    {
        if(left>=max&&right>=max)
        {
            list.add(combination);
            return;
        }
        if(left < max)
        {
            backtrack(list, left+1, right, max, combination+'(');
        }
        if(right < left)
        {
            backtrack(list, left, right+1, max, combination+')');
        }
    }
}