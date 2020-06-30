/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) return level + 1;

                char[] wordArr = currWord.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char temp = wordArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        if (!visited.contains(newWord) && wordSet.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordArr[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}
// @lc code=end

