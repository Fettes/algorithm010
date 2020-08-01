/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        
        for (int leftIndex = left, rightIndex = mid + 1; leftIndex <= mid && rightIndex <= right;) {
            if (nums[leftIndex] > (long)nums[rightIndex] * 2) {
                count += mid + 1 - leftIndex;
                rightIndex++;
            } else {
                leftIndex++;
            } 
        }

        merge(nums, left, right);
        return count;
    }

    public void merge(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        //the start index of leftpart
        int leftIndex = left;
        //the start index of rightpart
        int rightIndex = mid + 1;

        //initialize a new array to save the newly sorted array
        int[] sortedArr = new int[right - left + 1];
        //the start index of sotedIndex array
        int sortedIndex = 0;


        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                sortedArr[sortedIndex] = nums[leftIndex];
                leftIndex++;
            } else {
                sortedArr[sortedIndex] = nums[rightIndex];
                rightIndex++;
            }
            sortedIndex++;
        }

        //corner cases: if the right part has less element, the elements left should be largest element
        while (leftIndex <= mid) {
            sortedArr[sortedIndex] = nums[leftIndex];
            leftIndex++;
            sortedIndex++;
        }
        //same corner case to the right, there is no smaller element after
        while (rightIndex <= right) {
            sortedArr[sortedIndex] = nums[rightIndex];
            rightIndex++;
            sortedIndex++;
        }
        //copy the sotedIndexArry to orignal index array
        for (int i = left; i <= right; i++) {
            nums[i] = sortedArr[i - left];
        }
    }
}
// @lc code=end

