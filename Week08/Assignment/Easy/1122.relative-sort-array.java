/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        //count the number
        for (int num : arr1) {
            bucket[num]++;
        }
        //sort the element
        int i = 0;
        for (int num : arr2) {
            while (bucket[num] > 0) {
                arr1[i] = num;
                i++;
                bucket[num]--;
            }
        }

        //fill the rest
        for (int j = 0; j < 1001; j++) {
            while (bucket[j] > 0) {
                arr1[i] = j;
                i++;
                bucket[j]--;
            }
        }
        return arr1;

    }
}
// @lc code=end

