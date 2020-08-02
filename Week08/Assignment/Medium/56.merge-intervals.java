/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                int tempMax = Math.max(result.get(result.size() - 1)[1], interval[1]);
                result.get(result.size() - 1)[1] = tempMax;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a1, int[] a2) {
            return a1[0] - a2[0];
        }
    }
}

/*
Facebook Follow-Up
Question: How do you add intervals and merge them for a large stream of intervals? (Facebook Follow-up Question)

Method 1: Inspired by https://leetcode.com/problems/merge-intervals/discuss/21452/Share-my-interval-tree-solution-no-sorting

We need to have two functions for the tree [add interval and query tree]. (https://leetcode.com/problems/merge-intervals/solution/)

Method 2: Use heap to control the stream. (Personal Idea).

*/
// @lc code=end

