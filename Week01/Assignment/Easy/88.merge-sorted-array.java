/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int resp = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[resp] = nums1[p1];
                p1--;
                resp--;
            } else {
                nums1[resp] = nums2[p2];
                p2--;
                resp--;
            }
        }
        //The remaining numbers are the smallest numbers in nums2.
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
// @lc code=end

