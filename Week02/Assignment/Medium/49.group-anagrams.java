/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String temp = String.valueOf(curr);

            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(strs[i]);
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] letter = new char[26];
            char[] arr = s.toCharArray();
            for (char c : arr) {
                letter[c - 'a']++;
            }
            String newStr = String.valueOf(letter);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }

            map.get(newStr).add(s);
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
// @lc code=end

