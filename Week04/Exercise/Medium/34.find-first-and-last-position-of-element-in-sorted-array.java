/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) return result;

        int leftMostIndex = fisrtBinarySearch(nums, target);
        if (nums[leftMostIndex] != target || leftMostIndex == nums.length) {
            return result;
        }

        int rightMostIndex = lastBinarySearch(nums, target);
        return new int[]{leftMostIndex, rightMostIndex - 1};
    }

    public int fisrtBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || nums[mid] == target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int lastBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
// @lc code=end

