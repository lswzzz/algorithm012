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

传统的BFS就是从起点开始向四周扩散，遇到重点时停止，而双向BFS则是从起点和终点同时开始扩散，当两边有交集的时候停止。
双向BFS会更快的原因在于传统BFS会把整棵树的节点都搜索一遍，最后找到target，而双向BFS只遍历了半颗树就会出现交集，因此找到了最短距离。
但双向BFS也有局限，必须先知道终点在哪里。
双向BFS代码模板:
```java
public String doubleBFS(String start, String end)
{
	Queue<String> queue1 = new LinkedList<String>();
	Queue<String> queue2 = new LinkedList<String>();
	Set<String> visited = new HashSet<String>();
	queue1.add(start);
	queue2.add(end);
	while(!queue1.isEmpty()&&!queue2.isEmpty())
	{
		Queue<String> temp = new LinkedList<String>();
		for(String cur : queue1){
			//判断是否结尾
			if(queue2.contains(cur))
			{
				return cur;
			}
			visited.add(cur);
			//将接下来的相邻节点加入集合中
			String[] words = process(cur);
			for(String word : words)
			{
				if(!visited.contains(word))
				{
					temp.add(word);
				}
			}
		}
		//每次迭代后交换queue1和queue2
		queue1 = queue2;
		queue2 = temp;
	}
	return "";
}
```

