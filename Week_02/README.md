###课后作业
| 题号  | 名称  | 难度  | 分类  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| [242](https://leetcode-cn.com/problems/valid-anagram/)  | [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/ "有效的字母异位词")  | 简单  | 排序  |   |
| [1](https://leetcode-cn.com/problems/two-sum/description/ "1")  | [两数之和](https://leetcode-cn.com/problems/two-sum/description/ "两数之和")  | 简单  | 哈希  |   |
| [589](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/ "589")  | [N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/ "N叉树的前序遍历")  | 简单  | 二叉树  |   |
| [49](https://leetcode-cn.com/problems/group-anagrams/ "49")  | [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/ "字母异位词分组")  | 中等  | 排序  |   |
| [94](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ "94")  | [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ "二叉树的中序遍历")  | 中等  | 二叉树  |   |
| [144](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/ "144")  | [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/ "二叉树的前序遍历")  | 中等  | 二叉树  |   |
| [429](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ "429")  | [N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ "N叉树的前序遍历")  | 中等  | 二叉树  |   |
| [49](https://leetcode-cn.com/problems/chou-shu-lcof/ "49")  | [丑数](https://leetcode-cn.com/problems/chou-shu-lcof/ "丑数")  | 中等  |   |   |
| [347](https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode/ "347")  | [前K个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode/ "前K个高频元素")  |中等   | 最小堆  |   |   |


###学习笔记
#####HashMap
HashMap内部维护一个Node<K,V>的链表结构，Node的hash变量是通过调用`hash(key)`方法对key进行操作转换得来的`node.hash==hash(node.key)`
而Map内部用hash方法重新计算key的hashcode
```java
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```
使用`Node<K,V>[] table`数组保存数据，当key进行了一次`(len-1)&hash(key)`操作后就能等到数组的下标位置
在`getNode`方法实现中：
1.通过`tab[(n - 1) & hash]`来找到key对应的value的数据，当`first.hash==hash && (first.key==key || (key != null && key.equals(k)))`则说明要找Node在链表的起始位置，直接返回即可，否则遍历first链表查找到对应的Node
```java
final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            return first;
        if ((e = first.next) != null) {
            if (first instanceof TreeNode)
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    return null;
}
```
在`containsKey`中调用了`getNode`来判断是否存在key
```java
public boolean containsKey(Object key) {
        return getNode(hash(key), key) != null;
}
```
在`putVal`内部：
如果`(p = tab[i = (n - 1) & hash]) == null`则表明key对应位置的为空，直接添加一个新node
`tab[i] = newNode(hash, key, value, null);`
否则分三种情况：
1.如果key是在Node链表的起始位置，直接替换他的值
2.如果Node是一个TreeNode，调用putTreeVal添加一个新的TreeNode，然后替换他的值
3.如果Node是一个链表，找到链表的结尾，添加一个新的node，然后替换他的值
```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
	Node<K,V>[] tab; Node<K,V> p; int n, i;
	if ((tab = table) == null || (n = tab.length) == 0)
		n = (tab = resize()).length;
	if ((p = tab[i = (n - 1) & hash]) == null)
		tab[i] = newNode(hash, key, value, null);
	else {
		Node<K,V> e; K k;
		if (p.hash == hash &&
			((k = p.key) == key || (key != null && key.equals(k))))
			e = p;
		else if (p instanceof TreeNode)
			e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
		else {
			for (int binCount = 0; ; ++binCount) {
				if ((e = p.next) == null) {
					p.next = newNode(hash, key, value, null);
					if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
						treeifyBin(tab, hash);
					break;
				}
				if (e.hash == hash &&
					((k = e.key) == key || (key != null && key.equals(k))))
					break;
				p = e;
			}
		}
		if (e != null) { // existing mapping for key
			V oldValue = e.value;
			if (!onlyIfAbsent || oldValue == null)
				e.value = value;
			afterNodeAccess(e);
			return oldValue;
		}
	}
	++modCount;
	if (++size > threshold)
		resize();
	afterNodeInsertion(evict);
	return null;
}
```