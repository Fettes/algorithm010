# Week 8 Study Note
## Sort Algorithm
### Quick Sort

### Merge Sort
Like [QuickSort](#quick-sort), Merge Sort is a Divide and Conquer algorithm. 

It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. 

The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. 

![mergesort](Assets/mergesort.png)

```
// example of merge sort in Java

// Arr is an array of integer type
// start and end are the starting and ending index of current interval of Arr

void mergeSort(int Arr[], int start, int end) {
    if (end <= start) return;
	
    int mid = (start + end) / 2;
	mergeSort(Arr, start, mid);
	mergeSort(Arr, mid + 1, end);
	merge(Arr, start, end);
}

// merge function take two intervals
// one from start to mid
// second from mid + 1, to end
// and merge them in sorted order

void merge(int Arr[], int start, int end) {

	// create a temp array
	int temp[] = new int[end - start + 1];

	// crawlers for both intervals and for temp
	int mid = (start + end) / 2;
	int i = start, j = mid + 1, k = 0;

	// traverse both arrays and in each iteration add smaller of both elements in temp 
	while(i <= mid && j <= end) {
        temp[k++] = Arr[i] <= Arr[j] ? Arr[i++] : Arr[j++];
	}

	// add elements left in the first interval 
	while(i <= mid) {
		temp[k++] = Arr[i++];
	}

	// add elements left in the second interval 
	while(j <= end) {
		temp[k++] = Arr[j++];
	}

	// copy temp to original interval
	for(i = start; i <= end; i += 1) {
		Arr[i] = temp[i - start];
	}
}
```

> Sample Problems:
> |  Problem  | Status |
> |--------- |------- |
> |[Count of Smaller after self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=darkred&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/Divide%20And%20Conquer/315.count-of-smaller-numbers-after-self.java)
> |[Count of Range Sum](https://leetcode.com/problems/count-of-range-sum/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=darkred&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/DP/746.min-cost-climbing-stairs.java)
> |[Reverse Pairs](https://leetcode.com/problems/reverse-pairs/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=darkred&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/Divide%20And%20Conquer/493.reverse-pairs.java) |
