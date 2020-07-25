/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    class TrieNode {
        public boolean isEndOfWord;
        public TrieNode[] children;
        public char val;
        
        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
        
    }

    class Trie {
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }
        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode wordStart = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                
                if (wordStart.children[c - 'a'] == null) {
                    wordStart.children[c - 'a'] = new TrieNode();
                    wordStart.children[c - 'a'].val = c;
                }
        
                wordStart = wordStart.children[c - 'a'];
            }
            wordStart.isEndOfWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode wordStart = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (wordStart.children[c - 'a'] == null) {
                    return false;
                }
                wordStart = wordStart.children[c - 'a'];
            }
            return wordStart.isEndOfWord;
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode wordStart = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (wordStart.children[c - 'a'] == null) {
                    return false;
                }
                wordStart = wordStart.children[c - 'a'];
            }
            return true;
        }
    }

    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> result = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfsHelper(board, visited, "", i, j, trie, result);
            }
        }

        return new ArrayList<>(result);
    }

    public void dfsHelper(char[][] board, boolean[][] visited, String word, int i, int j, Trie trie, Set<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }

        word += board[i][j];
        if (!trie.startsWith(word)) {
            return;
        }

        if (trie.search(word)) {
            result.add(word);
        }

        //dfs
        visited[i][j] = true;
        dfsHelper(board, visited, word, i + 1, j, trie, result);
        dfsHelper(board, visited, word, i - 1, j, trie, result);
        dfsHelper(board, visited, word, i, j + 1, trie, result);
        dfsHelper(board, visited, word, i, j - 1, trie, result);
        visited[i][j] = false;
    }
}

//Time Complexity：O(m*n*4^l)

// @lc code=end

