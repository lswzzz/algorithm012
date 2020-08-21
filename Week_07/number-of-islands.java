import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n<=0)return 0;
        int m = grid[0].length;
        if(m<=0)return 0;
        int count = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j)
    {
        int n = grid.length;
        int m = grid[0].length;
        if(i>=n||j>=m||i<0||j<0||grid[i][j]=='0')return;
        grid[i][j]='0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}