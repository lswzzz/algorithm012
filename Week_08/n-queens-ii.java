import java.util.*;

class Solution {
    public int backtrack(int row, int pie_occupied, int col_occupied, int na_occupied, int count, int n)
    {
        int fill = (1<<n)-1;
        if(row==n) count++;
        else
        {
            int empty_columns = fill & ~(pie_occupied | col_occupied | na_occupied);
            while(empty_columns!=0)
            {
                int cur_column = empty_columns & -empty_columns;
                empty_columns ^= cur_column;
                count = backtrack(row+1,
                        (pie_occupied | cur_column) >> 1,
                        col_occupied | cur_column,
                        (na_occupied | cur_column) << 1,
                        count, n);
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        return backtrack(0, 0, 0, 0, 0, n);
    }
}