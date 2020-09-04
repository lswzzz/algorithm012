###课后作业
| 题号  | 名称  | 难度  | 分类  |
| ------------ | ------------ | ------------ | ------------ |
| [387](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)  | [字符串中的第一个唯一字符](https://github.com/lswzzz/algorithm012/blob/master/Week_09/first-unique-character-in-a-string.java)  | 简单  |   |
| [541](https://leetcode-cn.com/problems/reverse-string-ii/)  | [反转字符串 II](https://github.com/lswzzz/algorithm012/blob/master/Week_09/reverse-string-ii.java)  | 简单  |   |
| [151](https://leetcode-cn.com/problems/reverse-words-in-a-string/)  | [翻转字符串里的单词](https://github.com/lswzzz/algorithm012/blob/master/Week_09/reverse-words-in-a-string.java)  | 简单  |   |
| [557](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/)  | [反转字符串中的单词 III](https://github.com/lswzzz/algorithm012/blob/master/Week_09/reverse-words-in-a-string-iii.java)  | 简单  |   |
| [917](https://leetcode-cn.com/problems/reverse-only-letters/)  | [仅仅反转字母](https://github.com/lswzzz/algorithm012/blob/master/Week_09/reverse-only-letters.java)  | 简单  |   |
| [205](https://leetcode-cn.com/problems/isomorphic-strings/)  | [同构字符串](https://github.com/lswzzz/algorithm012/blob/master/Week_09/isomorphic-strings.java)  | 简单  |   |
| [680](https://leetcode-cn.com/problems/valid-palindrome-ii/)  | [验证回文字符串 Ⅱ](https://github.com/lswzzz/algorithm012/blob/master/Week_09/valid-palindrome-ii.java)  | 简单  |   |
| [300](https://leetcode-cn.com/problems/longest-increasing-subsequence/)  | [最长上升子序列](https://github.com/lswzzz/algorithm012/blob/master/Week_09/longest-increasing-subsequence.java)  | 中等  |   |
| [91](https://leetcode-cn.com/problems/decode-ways/)  | [解码方法](https://github.com/lswzzz/algorithm012/blob/master/Week_09/decode-ways.java)  | 中等   |   |
| [8](https://leetcode-cn.com/problems/string-to-integer-atoi/)  | [字符串转换整数 (atoi)](https://github.com/lswzzz/algorithm012/blob/master/Week_09/string-to-integer-atoi.java)  | 中等   |   |
| [438](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)  | [找到字符串中所有字母异位词](https://github.com/lswzzz/algorithm012/blob/master/Week_09/find-all-anagrams-in-a-string.java)  | 中等   |   |
| [5](https://leetcode-cn.com/problems/longest-palindromic-substring/)  | [最长回文子串](https://github.com/lswzzz/algorithm012/blob/master/Week_09/longest-palindromic-substring.java)  | 中等   |   |
| [32](https://leetcode-cn.com/problems/longest-valid-parentheses/)  | [最长有效括号](https://github.com/lswzzz/algorithm012/blob/master/Week_09/longest-valid-parentheses.java)  | 困难   |   |
| [818](https://leetcode-cn.com/problems/race-car/)  | [赛车](https://github.com/lswzzz/algorithm012/blob/master/Week_09/race-car.java)  | 困难   |   |
| [44](https://leetcode-cn.com/problems/wildcard-matching/)  | [通配符匹配](https://github.com/lswzzz/algorithm012/blob/master/Week_09/wildcard-matching.java)  | 困难   |   |
| [115](https://leetcode-cn.com/problems/distinct-subsequences/)  | [不同的子序列](https://github.com/lswzzz/algorithm012/blob/master/Week_09/distinct-subsequences.java)  |困难   |   |   |

不同路径II:
我们用f(i,j)表示从坐标(0,0)到(i,j)的路径总数，u(i,j)表示坐标(i,j)是否可走，如果(i,j)有障碍物，则u(i,j)=0，否则u(i,j)=1
我们使用滚动数组思想来优化处理有障碍物的情况：
1.(i,j)位置只能从(i-1,j),(i,j-1)走到，而f(i',j')(i'>i,j'>j)与f(i,j)无关比如f(1,1)，f(2,2)=f(1,2)+f(2,1);
2.每次滚动一行，我们将每一列的值累加再加上它左边的值，f[j]= f[j] + f[j-1];当遇到障碍物时，表示所有到该点的路径都行不通，则设f[j]=0
动态规划转移方程为：
当u(i,j)=0则f(i,j)=0,
当u(i,j)=1则f(i,j)=f(i-1,j)+f(i,j-1);
具体实现如下
```java
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length, m = obstacleGrid[0].length;
    int[] f = new int[m];
    f[0] = obstacleGrid[0][0]==0?1:0;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(obstacleGrid[i][j]==1)
            {
                f[j]=0;
                continue;
            }
            if(j>0 && obstacleGrid[i][j-1] == 0)
            {
                f[j] += f[j-1];
            }
        }
    }
    return f[m-1];
}
```