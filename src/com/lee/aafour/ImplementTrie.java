package com.lee.aafour;

public class ImplementTrie {

	public static void main(String[] args) {
		ImplementTrie trie = new ImplementTrie();
		trie.insert("abcd");
		trie.insert("abcdx");
		trie.insert("abcdi");
		trie.insert("abcdw");
		
		System.out.println(trie.search("bg"));
		System.out.println(trie.search("abcdi"));
		System.out.println(trie.search("ab"));

		
		System.out.println(trie.startsWith("bg"));
		System.out.println(trie.startsWith("abcdi"));
		System.out.println(trie.startsWith("ab"));
	}
	
	TireNode root = new TireNode(' ');
	
    /** Initialize your data structure here. */
    public ImplementTrie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TireNode node = root;
		for (char c : word.toCharArray()) {
			int i = c - 'a';
			if (node.children[i] == null) {
				node.children[i] = new TireNode(c);
			}
			node = node.children[i];
		}
		node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TireNode node = root;
		for (char c : word.toCharArray()) {
			int i = c - 'a';
			if (node.children[i] == null) {
				return false;
			}
			node = node.children[i];
		}
		return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TireNode node = root;
		for (char c : prefix.toCharArray()) {
			int i = c - 'a';
			if (node.children[i] == null) {
				return false;
			}
			node = node.children[i];
		}
		return true;
    }
    
    class TireNode {
    	char c;
    	boolean isWord;
    	TireNode[] children = new TireNode[26];
        public TireNode(char c) {
            this.c = c;
        }
    }

}


