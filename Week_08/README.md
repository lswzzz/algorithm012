###课后作业
| 题号  | 名称  | 难度  | 分类  |
| ------------ | ------------ | ------------ | ------------ |
| [191](https://leetcode-cn.com/problems/number-of-1-bits/)  | [位1的个数](https://github.com/lswzzz/algorithm012/blob/master/Week_08/number-of-1-bits.java)  | 简单  |   |
| [231](https://leetcode-cn.com/problems/power-of-two/)  | [2的幂](https://github.com/lswzzz/algorithm012/blob/master/Week_08/power-of-two.java)  | 简单  |   |
| [190](https://leetcode-cn.com/problems/reverse-bits/)  | [颠倒二进制位](https://github.com/lswzzz/algorithm012/blob/master/Week_08/reverse-bits.java)  | 简单  |   |
| [1122](https://leetcode-cn.com/problems/relative-sort-array/)  | [数组的相对排序](https://github.com/lswzzz/algorithm012/blob/master/Week_08/relative-sort-array.java)  | 简单  |   |
| [242](https://leetcode-cn.com/problems/valid-anagram/)  | [有效的字母异位词](https://github.com/lswzzz/algorithm012/blob/master/Week_08/valid-anagram.java)  | 简单  |   |
| [146](https://leetcode-cn.com/problems/lru-cache/)  | [LRU缓存机制](https://github.com/lswzzz/algorithm012/blob/master/Week_08/lru-cache.java)  | 中等  |   |
| [56](https://leetcode-cn.com/problems/merge-intervals/)  | [合并区间](https://github.com/lswzzz/algorithm012/blob/master/Week_08/merge-intervals.java)  | 中等  |   |
| [51](https://leetcode-cn.com/problems/n-queens/)  | [N皇后](https://github.com/lswzzz/algorithm012/blob/master/Week_08/n-queens.java)  | 困难  |   |
| [52](https://leetcode-cn.com/problems/n-queens-ii/)  | [N皇后 II](https://github.com/lswzzz/algorithm012/blob/master/Week_08/n-queens-ii.java)  | 困难   |   |
| [493](https://leetcode-cn.com/problems/reverse-pairs/)  | [翻转对](https://github.com/lswzzz/algorithm012/blob/master/Week_08/reverse-pairs.java)  |困难   |   |   |

https://pandao.github.io/editor.md/en.html
冒泡排序：
冒泡排序重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
```java
public static int[] bubbleSort(int[] array)
{
	if(array.length == 0) return array;
	for(int i=0; i<array.length; i++)
	{
		boolean isSwap = false;
		for(int j=0; j<array.length-1-i; j++)
			if(array[j+1] < array[j])
		{
			int temp = array[j+1];
			array[j+1] = array[j];
			array[j] = temp;
			isSwap = true;
		}
		if(!isSwap) break;
	}
	return array;
}
```

选择排序：
选择排序工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
```java
public static int[] selectionSort(int[] array)
{
	if(array.length == 0) return array;
	for(int i=0; i<array.length; i++)
	{
		int minIndex = i;
		for(int j=i; j<array.length; j++)
			if(array[j] < array[minIndex])
			minIndex = j;

		int temp = array[minIndex];
		array[minIndex] = array[i];
		array[i] = temp;
	}
	return array;
}
```
插入排序：
插入排序工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
```java
public static int[] insertionSort(int[] array)
{
	if(array.length == 0) return array;
	int current;
	for(int i=1; i<array.length; i++)
	{
		current = array[i];
		int preIndex = i-1;
		while(preIndex>=0&&current<array[preIndex])
		{
			array[preIndex+1]=array[preIndex];
			preIndex--;
		}
		array[preIndex+1]=current;
	}
	return array;
}
```
归并排序：
归并排序采用分治法，将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
```java
public static int[] mergeSort(int[] array)
{
	if(array.length < 2) return array;
	int mid = array.length / 2;
	int[] left = Arrays.copyOfRange(array, 0, mid);
	int[] right = Arrays.copyOfRange(array, mid, array.length);
	return merge(mergeSort(left), mergeSort(right));
}

public static int[] merge(int[] left, int[] right)
{
	int[] result = new int[left.length+right.length];
	int i=0,j=0,k=0;
	while(i<left.length&&j<right.length){
		if(left[i]<=right[j])
			result[k++]=left[i++];
		else
			result[k++]=right[j++];
	}
	while(i<left.length){
		result[k++]=left[i++];
	}
	while(j<right.length){
		result[k++]=result[j++];
	}
	return result;
}
```
快速排序：
快速排序通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
```java
public static int partition(int[] array, int left, int right)
{
	int begin = left;
	int end = right;
	int key = right;
	while(begin<end){
		while(begin<end&&array[begin]<=array[key])
			begin++;
		while(begin<end&&array[end]>=array[key])
			end--;
		swap(array, begin, end);
	}
	swap(array, begin, right);
	return begin;
}

public static void swap(int[] array, int i, int j)
{
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
}

public static void quickSort(int array[], int left, int right)
{
	if(left < right)
	{
		int pos = partition(array, left, right);
		quickSort(array, left, pos-1);
		quickSort(array, pos+1, right);
	}
}
```

堆排序：
堆排序是一种树形选择排序方法，它利用了堆数据结构。在排序的过程中，将array[0，...，n-1]看成是一颗完全二叉树的顺序存储结构，利用完全二叉树中双亲结点和孩子结点之间的关系，在当前无序区中选择关键字最大（最小）的元素。
概念：
堆：堆是一种完全二叉树，且满足所有父节点的值均大于等于（或小于等于）其子节点的值。
大根堆（最大堆）：满足所有父节点的值均大于等于其子节点的值的堆称为大根堆，堆顶元素是堆中元素的最大值。
小根堆（最小堆）：满足所有父节点的值均小于等于其子节点的值的堆称为小根堆，堆顶元素是堆中元素的最小值。
堆的顺序存储结构：使用顺序数据结构（数组）存储堆，表示方法为：
1.数组按层序遍历的顺序存放完全二叉树的结点，下标为 0 处为堆顶，下标为 len - 1 处为堆尾。
2.结点 i 如果存在左孩子（下标不超过 len - 1 就存在），左孩子的下标为（2 * i + 1）；如果存在右孩子，右孩子的下标为（2 * i + 2）。结点 i 的父结点下标为 (i - 1) / 2 (下标为 0 的结点除外，它没有父结点)。最后一个非叶子结点即为堆尾元素的父结点，下标为 (len - 1 - 1) / 2 = (len - 2) / 2。
```java
static int len;
public static int[] heapSort(int[] array)
{
	len = array.length;
	if(len==0)return array;
	buildMaxHeap(array);
	while(len>0)
	{
		swap(array, 0, len-1);
		len--;
		adjustHeap(array, 0);
	}
	return array;
}

public static void adjustHeap(int[] array, int i)
{
	int maxIndex = i;
	if(2*i+1<len && array[2*i+1]>array[maxIndex])
		maxIndex = 2*i+1;
	if(2*i+2<len && array[2*i+2]>array[maxIndex])
		maxIndex = 2*i+2;
	if(maxIndex != i){
		swap(array, maxIndex, i);
		adjustHeap(array, maxIndex);
	}
}

public static void buildMaxHeap(int[] array)
{
	for(int i=(len-2)/2; i>=0; i--)
	{
		adjustHeap(array, i);
	}
}

public void swap(int[] array, int left, int right)
{
	int temp = array[left];
	array[left] = array[right];
	array[right] = temp;
}
```
计数排序：
计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
```java
public static int[] countingSort(int[] array)
{
	if(array.length == 0) return array;
	int bias, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
	for(int i=0;i<array.length;i++){
		max=Math.max(max,array[i]);
		min=Math.min(min,array[i]);
	}
	bias = -min;
	int[] bucket = new int[max-min+1];
	Arrays.fill(bucket, 0);
	for(int i=0;i<array.length;i++){
		bucket[array[i]+bias]++;
	}
	int index=0,i=0;
	while(index<array.length){
		if(bucket[i]!=0)
		{
			array[index]=i-bias;
			bucket[i]--;
			index++;
		}else
			i++;
	}
	return array;
}
```
桶排序：
桶排序按照映射函数将数据分配到不同的桶里，每个桶内元素再分别排序（可能使用别的排序算法），最后拼接各个桶中排好序的数据。映射函数人为设计，但要保证桶 i 中的数均小于桶 j （i < j）中的数，即必须桶间必须有序，桶内可以无序，可以考虑按照数的区间范围划分桶。下面代码的桶映射函数为：(i - min) / arr.length。
```java
public static int[] bucketSort(int[] array)
{
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	for(int i=0;i<array.length;i++)
	{
		max = Math.max(max, array[i]);
		min = Math.min(min, array[i]);
	}
	/*桶映射函数：自己设计，要保证桶 i 的数均小于桶 j （i < j）的数，
        即必须桶间必须有序，桶内可以无序。这里桶映射函数为：(i - min) / arr.length*/
	int bucketNum = (max-min)/array.length+1;
	ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
	for(int i=0;i<bucketNum;i++){
		bucketArr.add(new ArrayList<>());
	}
	//将每个元素放入桶
	for(int i=0;i<array.length;i++){
		int num = (array[i]-min)/array.length;
		bucketArr.get(num).add(array[i]);
	}
	//对每个桶进行排序
	for(int i=0;i<bucketArr.size();i++){
		Collections.sort(bucketArr.get(i));
	}
	int k=0;
	for(int i=0;i<bucketArr.size();i++)
	{
		for(int j=0;j<bucketArr.get(i).size();j++){
			array[k++]=bucketArr.get(i).get(j);
		}
	}
	return array;
}
```
基数排序：
基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
```java
public static int[] radixSort(int[] array) {
     if (array == null || array.length < 2)
        return array;
        // 1.先算出最大数的位数；
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
    }
    int maxDigit = 0;
    while (max != 0) {
            max /= 10;
            maxDigit++;
    }
    int div = 1;
    ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < 10; i++)
        bucketList.add(new ArrayList<Integer>());
        //2.进行maxDigit趟分配
    for (int i = 0; i < maxDigit; i++,div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] / div) % 10;
                bucketList.get(num).add(array[j]);
            }
        //3.收集
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
   }
   return array;
}
```