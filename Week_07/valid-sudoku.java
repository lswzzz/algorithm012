import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                int x=board[i][j]-'0';
                if(x>=1&&x<=9)
                {
                    rows[i][x-1]++;
                    columns[j][x-1]++;
                    boxes[i/3*3+j/3][x-1]++;
                    if(rows[i][x-1]>1||columns[j][x-1]>1||boxes[i/3*3+j/3][x-1]>1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}