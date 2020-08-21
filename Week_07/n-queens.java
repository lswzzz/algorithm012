import java.util.*;

class Solution {
    int rows[];
    int blues[];
    int reds[];
    int queens[];
    int n;
    List<List<String>> solution;

    public boolean isUnderAttack(int row, int col)
    {
        if(rows[col] != 0 || blues[row+col] != 0 || reds[row-col+n] != 0)return true;
        return false;
    }

    public void placeQueen(int row, int col)
    {
        rows[col] = 1;
        blues[row+col]=1;
        reds[row-col+n]=1;
        queens[row]=col;
    }

    public void removeQuee(int row, int col)
    {
        rows[col]=0;
        blues[row+col]=0;
        reds[row-col+n]=0;
        queens[row]=0;
    }

    public void addSolution()
    {
        List<String> sol = new ArrayList<String>();
        for(int row=0;row<n;row++)
        {
            StringBuilder sb = new StringBuilder();
            int col=queens[row];
            for(int i=0; i<col; i++)sb.append('.');
            sb.append('Q');
            for(int i=col+1;i<n;i++)sb.append('.');
            sol.add(sb.toString());
        }
        solution.add(sol);
    }

    public void backtrack(int row)
    {
        for(int col=0; col<n; col++)
        {
            if(!isUnderAttack(row, col))
            {
                placeQueen(row, col);
                if(row<n-1)backtrack(row+1);
                else addSolution();;
                removeQuee(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        rows = new int[n];
        blues = new int[2*n];
        reds = new int[2*n];
        queens = new int[n];
        solution = new ArrayList<>();
        this.n=n;
        backtrack(0);
        return solution;
    }
}