### 学习总结
我将做过的题大部分都把解题思路放到了leetCode上，最重要的是使用五毒神掌，将做过的题目复习，我使用了滴答清单来记录每天需要完成的LeetCode的题目，如果没有及时完成题目的吗，后面的工作会越来越多。。。
- [设计循环队列](https://leetcode-cn.com/problems/design-circular-deque/solution/she-ji-xun-huan-shuang-duan-dui-lie-shi-yong-shu-z/)
- [接雨水](https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-dong-tai-gui-hua-zhan-by-kkll-w/)
- [移动零](https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-kuai-man-zhi-zhen-fa-by-kkll-w/)
- [两数之和](https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-ji-yi-fa-by-kkll-w/)
- [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-di-gui-fa-he-die/)
- [合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-shuang-zhi-zhen-xia/)
- [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-s-9/)

##### 看了一下ArrayDeque的源码，照着写了一个：
```java
public void addFirst(E e) {
    if (e == null)
        throw new NullPointerException();
    elements[head = (head - 1) & (elements.length - 1)] = e;
    if (head == tail)
        doubleCapacity();
}

public void addLast(E e) {
    if (e == null)
        throw new NullPointerException();
    elements[tail] = e;
    if ( (tail = (tail + 1) & (elements.length - 1)) == head)
        doubleCapacity();
}
```
##### Queue队列是用先进先出的数据结构，下面对它的功能进行分析：
```java
//添加一个元素到队列结尾，如果队列满，抛出异常
boolean add(E e);
//添加一个元素到队列结尾
boolean offer(E e);
//从队列头部删除移除一个元素，如果队列为空，抛出异常
E remove();
//从队列头部删除一个元素
E poll();
//获取队列第一个元素，如果队列为空，抛出异常
E element();
//获取队列第一个元素
E peek();
```
##### PriorityQueue内部维护一个堆，每次取数据都会从堆顶拿出优先级最高的数据，创建时需要传入Comparator ，下面对它的功能进行分析
```java
//清除所有元素
public void clear() {
	modCount++;
	for (int i = 0; i < size; i++)
		queue[i] = null;
	size = 0;
}
//加入一个元素，并重新平衡树结构，如果队列已满，则扩容.
public boolean offer(E e) {
	if (e == null)
		throw new NullPointerException();
	modCount++;
	int i = size;
	if (i >= queue.length)
		grow(i + 1);
	size = i + 1;
	if (i == 0)
		queue[0] = e;
	else
		siftUp(i, e);
	return true;
}
//取出队列中优先级最高的第一个元素
public E peek() {
	return (size == 0) ? null : (E) queue[0];
}
//将队列头部的元素弹出，并重新平衡树
public E poll() {
	if (size == 0)
		return null;
	int s = --size;
	modCount++;
	E result = (E) queue[0];
	E x = (E) queue[s];
	queue[s] = null;
	if (s != 0)
		siftDown(0, x);
	return result;
}
//返回队列大小
public int size() {
	return size;
}
```
