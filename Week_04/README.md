#####二分查找，寻找一个数组 [4, 5, 6, 7, 0, 1, 2]中最小的值
数组元素经过偏移后，依然保持相对有序，我们可以把最下的值标记为target=0, 左指针为left, 右指针为right
如果将数组从中间拆分成两部分，那么必然有一部分是有序的，我们将数组设置为nums, 中间位置为mid=2, 在这个例子中拆分为[4, 5, 6], [7, 0, 1, 2], 那么第一个数组是有序的。
当出现下面两种情况时表明我们找到了最小值：
1.nums[mid+1]<nums[mid]表明右边是无序的，并且最小值是nums[mid+1]
2.nums[mid-1]>>nums[mid]表明左边是无序的，并且最小值是nums[mid]
如果没找到最小值，那么我们需要将左右指针偏移，继续查找：
当nums[0]<nums[mid]表明左边的数组是有序的，因此我们设left=mid+1
否则左边的数组是无序的，我们设right=mid-1

具体代码如下
```java
public int findMin(int[] nums) {
	if (nums.length == 1) {
		return nums[0];
	}
	int left = 0;
	int right = nums.length-1;
	if(nums[right] > nums[0])
	{
		return nums[0];
	}
	while(left<=right)
	{
		int mid = left + (right-left)/2;
		if(nums[mid]>nums[mid+1])return nums[mid+1];
		if(mid-1>=0 && nums[mid-1] > nums[mid])return nums[mid];
		if(nums[mid]>nums[0])
		{
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}
	return -1;
}
```

