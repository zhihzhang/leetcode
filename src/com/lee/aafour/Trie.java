package com.lee.aafour;

public class Trie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private TrieNode root = new TrieNode();
	
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c:word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c:word.toCharArray()) {
           if (node.containsKey(c)) {
               node = node.get(c);
           } else {
               return false;
           }
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode node = root;
        for (char c:word.toCharArray()) {
           if (node.containsKey(c)) {
               node = node.get(c);
           } else {
               return false;
           }
        }
        return true;
    }

}

class TrieNode {

    // R links to node children
    private TrieNode[] children = new TrieNode[26];

    private boolean isEnd;

    public TrieNode() {
    }

    public boolean containsKey(char ch) {
        return children[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return children[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
    	children[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
