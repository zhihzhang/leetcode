package com.lee.againt;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class StreamChecker {

	public static void main(String[] args) {
		StreamChecker obj = new StreamChecker(new String[]{"cd","f","kl"});
		System.out.println(obj.query('a'));
		System.out.println(obj.query('b'));
		System.out.println(obj.query('c'));
		System.out.println(obj.query('d'));
	}
	
	TrieNode root = new TrieNode();
	int max = 0;
	Set<String> set = new HashSet<>();
	Set<Integer> size = new HashSet<>();
	LinkedList<Character> list = new LinkedList<>();
	
    public StreamChecker(String[] words) {
        for(String w:words){
        	max = Math.max(max, w.length());
        	StringBuilder sb = new StringBuilder(w);
        	set.add(sb.reverse().toString());
        	size.add(w.length());
        }
        
    }
    
    public boolean query(char letter) {
		list.addFirst(letter);
		if (list.size() > max) {
			list.remove(list.size() - 1);
		}
		StringBuilder sb = new StringBuilder();
		for(Character c:list){
			sb.append(c);
			if(!size.contains(sb.length())){
				continue;
			}
			if(set.contains(sb.toString())){
				return true;
			}
		}
		return false;
    }
    
    private void createTrie(String[] words) {
        for (String s : words) {
            TrieNode node = root;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }

}

class TrieNode {
    boolean isWord;
    TrieNode[] next = new TrieNode[26];
}
