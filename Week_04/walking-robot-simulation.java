import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //direx,direy用于转向，得到x和y的方向
        int[] direx = {0, 1, 0, -1};
        int[] direy = {1, 0, -1, 0};
        int curx = 0, cury = 0;
        int curdire = 0;
        int commandLen = commands.length;
        int ans = 0;
        //注意obstacles[0].length=2
        HashSet<Long> obstacleSet = new HashSet<Long>();
        for(int i=0; i<obstacles.length; i++)
        {
            int[] obstacle = obstacles[i];
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }
        for(int i=0; i<commandLen; i++)
        {
            if(commands[i] == -1)
            {
                curdire = (curdire + 1) % 4;
            }else if(commands[i] == -2)
            {
                curdire = (curdire + 3) % 4;
            }else
            {
                for(int j=0; j<commands[i]; j++)
                {
                    int nx = curx + direx[curdire];
                    int ny = cury + direy[curdire];
                    long code = (((long)nx + 30000)<<16) + ((long)ny + 30000);
                    if(obstacleSet.contains(code)) break;
                    curx = nx;
                    cury = ny;
                    ans = Math.max(ans, curx*curx + cury*cury);
                }
            }
        }
        return ans;
    }
}