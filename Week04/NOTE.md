# Week 4 Study Note
## Binary Search
### How do we identify Binary Search?
Binary Search is an algorithm that divides the search space in 2 after every comparison. Binary Search should be considered every time you need to search for an index or element in a collection. If the collection is unordered, we can always sort it first before applying Binary Search.

### 3 Parts of Binary Search
1. **Pre-processing** - Sort if collection is unsorted.
2. **Binary Search** - Using a loop or recursion to divide search space in half after each comparison.
3. **Post-processing** - Determine viable candidates in the remaining space.

### 3 Templates for Binary Search
#### Template I
```
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;

    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // End Condition: left > right
  return -1;
}
```
[Template #1](#template-i) is used to search for an element or condition which can be determined by accessing a single index in the array.
- Most basic and elementary form of Binary Search
- Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
- No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found.

> Sample Problems:
> |  Problem  | Status |
> |--------- |------ |
> |[Sqrt(x)](https://leetcode.com/problems/sqrtx/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=brightgreen&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/Binary%20Seach/69.sqrt-x.java) |
> |[Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=brightgreen&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/Binary%20Seach/374.guess-number-higher-or-lower.java)
> |[Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=yellow&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/Binary%20Seach/33.search-in-rotated-sorted-array.java)

#### Template II
```
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){

    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;

    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
```
[Template #2](#template-ii) is an advanced form of Binary Search. It is used to search for an element or condition which requires accessing the current index and its immediate right neighbor's index in the array.
- Search Condition needs to access element's immediate right neighbor
- Use element's right neighbor to determine if condition is met and decide whether to go left or right
- Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.

> Sample Problems:
> |  Problem  | Status |
> |--------- |------ |
> |[First Bad Version](https://leetcode.com/problems/first-bad-version/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=brightgreen&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/Binary%20Seach/278.first-bad-version.java) |
> |[Find Peak Element](https://leetcode.com/problems/find-peak-element/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=yellow&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/Binary%20Seach/162.find-peak-element.java)
> |[Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=yellow&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/Binary%20Seach/153.find-minimum-in-rotated-sorted-array.java)