/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return result;
        }

        //Get the minimum path 
        Set<String> visited = new HashSet<>();
        //Save the currpath in the queue
        Queue<List<String>> queue = new LinkedList<>();
        //Begin with the first word
        List<String> firstWord = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(firstWord);
        visited.add(beginWord);
        boolean end = false;

        while (!queue.isEmpty() && !end) {
            int size = queue.size();
            Set<String> levelVisitSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> currPath = queue.poll();
                String lastWord = currPath.get(currPath.size() - 1);
                //terminate
                if (lastWord.equals(endWord)) {
                    result.add(currPath);
                    end = true;
                }

                char[] wordArr = lastWord.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char temp = wordArr[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String newWord = new String(wordArr);
                        if (c == temp) continue;
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            List<String> newPath = new ArrayList<>(currPath);
                            newPath.add(newWord);
                            queue.add(newPath);
                            levelVisitSet.add(newWord);
                        }
                    }
                    wordArr[j] = temp;
                }
            }
            visited.addAll(levelVisitSet);
        }
        return result;
    }
}
     
// @lc code=end

