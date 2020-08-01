import java.util.*;

class Solution {
    public void dfs(char[][] grid, int i, int j)
    {
        int n = grid.length;
        int k = grid[0].length;
        if(i<0||j<0||i>=n||j>=k||grid[i][j]=='0')return;
        grid[i][j]='0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}