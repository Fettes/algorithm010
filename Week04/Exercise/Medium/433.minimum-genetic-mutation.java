/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int count = 0;

        for (String s : bank) bankSet.add(s);
        char[] keySet = new char[]{'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
             int size = queue.size();
             //Level traverse depend on queue size
             for (int i = 0; i < size; i++) {
                 String curr = queue.poll();
                 if (curr.equals(end)) return count;

                 //traverse all the character
                 char[] geneArr = curr.toCharArray();
                 for (int j = 0; j < geneArr.length; j++) {
                     char temp = geneArr[j];

                     //traverse all the possible key
                     for (char key : keySet) {
                         geneArr[j] = key;
                         String newMut = new String(geneArr);
                        
                         //judge and drill down
                         if (!visited.contains(newMut) && bankSet.contains(newMut)) {
                             queue.add(newMut);
                             visited.add(newMut);
                         }
                     }
                     geneArr[j] = temp;
                 }
             }
             count++;
        }
        return -1;

    }
}
// @lc code=end

