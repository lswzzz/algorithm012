import java.util.*;

class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new LinkedList();
        generateParenthesis(0, 0, n, "");
        return res;
    }

    public void generateParenthesis(int left, int right, int max, String str)
    {
        if(left >= max && right >= max)
        {
            res.add(str);
            return;
        }
        if(left < max)
        {
            generateParenthesis(left+1, right, max, str+"(");
        }
        if(left > right)
        {
            generateParenthesis(left, right+1, max, str+")");
        }
    }
}