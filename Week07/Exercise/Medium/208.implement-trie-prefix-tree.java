/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class TrieNode {
    public boolean isEndOfWord;
    public TrieNode[] children = new TrieNode[26];
    
    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

