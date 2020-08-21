import java.util.*;

class Solution {
    class UnionFind
    {
        int[] parents;
        public UnionFind(int totalNodes)
        {
            parents = new int[totalNodes];
            for(int i=0;i<totalNodes;i++)
            {
                parents[i]=i;
            }
        }
        void union(int node1, int node2)
        {
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1!=root2)
            {
                parents[root2] = root1;
            }
        }
        int find(int node)
        {
            while(parents[node]!=node)
            {
                //路径压缩
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }
        boolean isConnected(int node1, int node2)
        {
            return find(node1)==find(node2);
        }
    }

    int rows;
    int cols;
    public void solve(char[][] board){
        if(board==null||board.length==0||board[0].length==0)return ;
        rows=board.length;
        cols=board[0].length;
        UnionFind uf = new UnionFind(rows*cols+1);
        int dummyNode = rows*cols;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]=='O')
                {
                    if(i==0||i==rows-1||j==0||j==cols-1)
                    {
                        uf.union(node(i, j), dummyNode);
                    }else
                    {
                        if(i>0&&board[i-1][j]=='O')
                            uf.union(node(i, j), node(i-1, j));
                        if(i<rows-1&&board[i+1][j]=='O')
                            uf.union(node(i, j), node(i+1, j));
                        if(j>0&&board[i][j-1]=='O')
                            uf.union(node(i, j), node(i, j-1));
                        if(i<cols-1&&board[i][j+1]=='O')
                            uf.union(node(i, j), node(i, j+1));
                    }
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(uf.isConnected(node(i, j), dummyNode))
                {
                    board[i][j] = 'O';
                }else
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    int node(int i, int j)
    {
        return i*cols+j;
    }
}