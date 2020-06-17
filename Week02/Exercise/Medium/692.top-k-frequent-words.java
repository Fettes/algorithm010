/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                int count1 = map.get(s1);
                int count2 = map.get(s2);

                if (count1 == count2) {
                    //The value 0 if the argument string is equal to this string; 
                    //a value less than 0 if this string is lexicographically less than the string argument;
                    //and a value greater than 0 if this string is lexicographically greater than the string argument.
                    return s1.compareTo(s2);
                } else {
                    return count2 - count1;
                }
            }
        });

        for (String word : map.keySet()) {
            heap.add(word);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            result.add(heap.poll());
        }
        return result;
    }
}
// @lc code=end

