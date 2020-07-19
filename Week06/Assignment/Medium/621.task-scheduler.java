/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //step1: count the frequency
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Step2: add to priority queue to sort
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue()- a.getValue());
        queue.addAll(map.entrySet());

        //Step3: let n + 1 to be one task cycle.
        int result = 0;
        while (!queue.isEmpty()) {
            int cycle = n + 1;
            //to avoid add the same task again, we put the added tasks to a new list.
            List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();

            while (cycle > 0 && !queue.isEmpty()) {
                //poll the most frequency task, minus the frequency, add to temp list.
                Map.Entry<Character, Integer> task = queue.poll();
                task.setValue(task.getValue() - 1);
                tempList.add(task);
                cycle--;
                result++;
            }

            //Step4: reset the priorityqueue after one cycle
            for (Map.Entry<Character, Integer> entry : tempList) {
                if (entry.getValue() > 0) {
                    queue.add(entry);
                }
            }

            //if the cycle more than 0, we need to set idle interval
            if (!queue.isEmpty()) {
                result += cycle;
            }
        }
        return result;
    }
}
//Time Complexity: O(nlog26) = O(n)
// @lc code=end

