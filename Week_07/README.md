###课后作业
| 题号  | 名称  | 难度  | 分类  |
| ------------ | ------------ | ------------ | ------------ |
| [70](https://leetcode-cn.com/problems/climbing-stairs/)  | [爬楼梯](https://github.com/lswzzz/algorithm012/blob/master/Week_07/climbing-stairs.java)  | 中等  |   |
| [208](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)  | [实现 Trie (前缀树)](https://github.com/lswzzz/algorithm012/blob/master/Week_07/implement-trie-prefix-tree.java)  | 中等  |   |
| [547](https://leetcode-cn.com/problems/friend-circles/)  | [朋友圈](https://github.com/lswzzz/algorithm012/blob/master/Week_07/friend-circles.java)  | 中等  |   |
| [200](https://leetcode-cn.com/problems/number-of-islands/)  | [岛屿数量](https://github.com/lswzzz/algorithm012/blob/master/Week_07/number-of-islands.java)  | 中等  |   |
| [130](https://leetcode-cn.com/problems/surrounded-regions/)  | [被围绕的区域](https://github.com/lswzzz/algorithm012/blob/master/Week_07/surrounded-regions.java)  | 中等  |   |
| [36](https://leetcode-cn.com/problems/valid-sudoku/)  | [有效的数独](https://github.com/lswzzz/algorithm012/blob/master/Week_07/valid-sudoku.java)  | 中等  |   |
| [22](https://leetcode-cn.com/problems/generate-parentheses/)  | [括号生成](https://github.com/lswzzz/algorithm012/blob/master/Week_07/generate-parentheses.java)  | 中等  |   |
| [127](https://leetcode-cn.com/problems/word-ladder/)  | [单词接龙](https://github.com/lswzzz/algorithm012/blob/master/Week_07/word-ladder.java)  | 中等  |   |
| [433](https://leetcode-cn.com/problems/minimum-genetic-mutation/)  | [最小基因变化](https://github.com/lswzzz/algorithm012/blob/master/Week_07/minimum-genetic-mutation.java)  | 中等   |   |
| [212](https://leetcode-cn.com/problems/word-search-ii/)  | [单词搜索 II](https://github.com/lswzzz/algorithm012/blob/master/Week_07/word-search-ii.java)  |困难   |   |
| [51](https://leetcode-cn.com/problems/n-queens/)  | [N皇后](https://github.com/lswzzz/algorithm012/blob/master/Week_07/n-queens.java)  |困难   |   |
| [37](https://leetcode-cn.com/problems/sudoku-solver/)  | [解数独](https://github.com/lswzzz/algorithm012/blob/master/Week_07/sudoku-solver.java)  |困难   |   |   |

BFS代码模板:
```java
public void BFS(int start, int end)
{
	HashSet<Integer> set1 = new HashSet<Integer>();
	HashSet<Integer> set2 = new HashSet<Integer>();
	set1.add(start);
	set2.add(end);
	while(!set1.isEmpty()&&!set2.isEmpty())
	{
		for(int val : set1)
		{
			if(set2.contains(val))
			{
				return;
			}
			var nodes = process(val);
			set1.add(nodes);
		}
		if(set1.size()>set2.size())
		{
			HashSet<Integer> tp = set1;
			set1 = set2;
			set2 = tp;
		}
	}
}
```

