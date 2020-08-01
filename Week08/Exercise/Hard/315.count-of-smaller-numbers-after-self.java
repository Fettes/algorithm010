/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        int[] result = new int[nums.length];
        mergeSort(nums, index, 0, nums.length - 1, result);

        //add result to list
        List<Integer> resultList = new ArrayList<>();
        for (int i : result) resultList.add(i);
        return resultList;
    }

    private void mergeSort(int[] nums, int index[], int left, int right, int[] result) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        mergeSort(nums, index, left, mid, result);
        mergeSort(nums, index, mid + 1, right, result);
        merge(nums, index, left, right, result);
    }

    public void merge(int[] nums, int[] index, int left, int right, int[] result) {
        int mid = (left + right) / 2;
        int leftIndex = left;
        int rightIndex = mid + 1;

        //sort the index by number
        int[] sortedIndexArr = new int[right - left + 1];
        int sortIndex = 0;

        //count the current number which is smaller
        int countSmaller = 0;

        while (leftIndex <= mid && rightIndex <= right) {
            //compare the original number before sort
            if (nums[index[leftIndex]] <= nums[index[rightIndex]]) {
                sortedIndexArr[sortIndex] = index[leftIndex];
                result[index[leftIndex]] += countSmaller;
                leftIndex++;
            } else {
                sortedIndexArr[sortIndex] = index[rightIndex];
                countSmaller++;
                rightIndex++;
            }
            sortIndex++;
        }
        //corner cases: if the right part has less element, the elements left should be largest element
        while (leftIndex <= mid) {
            sortedIndexArr[sortIndex] = index[leftIndex];
            result[index[leftIndex]] += countSmaller;
            leftIndex++;
            sortIndex++;
        }
        //same corner case to the right, there is no smaller element after
        while (rightIndex <= right) {
            sortedIndexArr[sortIndex] = index[rightIndex];
            rightIndex++;
            sortIndex++;
        }
        //copy the newly array which sort the index by number to the orignal address
        for (int i = left; i <= right; i++) {
            index[i] = sortedIndexArr[i - left];
        }
    }
}
// @lc code=end

