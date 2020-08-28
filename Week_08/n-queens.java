import java.util.*;

class Solution {
    int[] rows;
    int[] blues;
    int[] reds;
    int[] queens;
    int n;
    List<List<String>> solution;

    public boolean isUnderAttack(int row, int col)
    {
        if(rows[col]!=0||blues[row+col]!=0||reds[row-col+n]!=0) return true;
        return false;
    }

    public void placeQueue(int row, int col)
    {
        rows[col]++;
        blues[row+col]++;
        reds[row-col+n]++;
        queens[row] = col;
    }

    public void removeQueue(int row, int col)
    {
        rows[col]--;
        blues[row+col]--;
        reds[row-col+n]--;
        queens[row]=0;
    }

    public void addSolution()
    {
        List<String> solo = new ArrayList<String>();
        for(int i=0;i<n;i++)
        {
            StringBuffer sb = new StringBuffer();
            int col = queens[i];
            for(int j=0;j<col;j++)sb.append('.');
            sb.append('Q');
            for(int j=col+1;j<n;j++)sb.append('.');
            solo.add(sb.toString());
        }
        solution.add(solo);
    }

    public void backtrack(int row)
    {
        for(int col=0;col<n;col++)
        {
            if(!isUnderAttack(row, col))
            {
                placeQueue(row, col);
                if(row==n-1) addSolution();
                else backtrack(row+1);
                removeQueue(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        solution = new ArrayList<>();
        rows = new int[n];
        blues = new int[n*2];
        reds = new int[n*2];
        queens = new int[n];
        backtrack(0);
        return solution;
    }
}