package com.lee.aafour;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BraceExpansionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// "{a,b}{c,{d,e}}"
	// "{{a,z},a{b,c},{ab,z}}"
	// "{{a,z},a{b,c}{x,y},{ab,z}}"
	// {a{b,c}{d,e}f{g,h}}
	public List<String> braceExpansionII(String expression) {
		List<String> r = new ArrayList<>();
		LinkedList<Character> queue = new LinkedList<>();
		for (Character c : expression.toCharArray()) {
			if (c == '}') {
				;
			} else {
				queue.offer(c);
			}
		}
		return null;

	}

}
