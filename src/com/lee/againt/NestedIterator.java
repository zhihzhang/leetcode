package com.lee.againt;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Deque<Integer> queue = new LinkedList<>();

	private void populateData(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.isEmpty()) {
			return;
		}
		for (NestedInteger i : nestedList) {
			if (i.isInteger()) {
				queue.addLast(i.getInteger());
			} else {
				populateData(i.getList());
			}
		}
	}

	public NestedIterator(List<NestedInteger> nestedList) {
		populateData(nestedList);
	}

	public Integer next() {
		if (!queue.isEmpty()) {
			return queue.poll();
		}
		return null;
	}

	public boolean hasNext() {
		return queue.isEmpty();
	}

}

class NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger() {
		return true;
	}

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return 0;
	}

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return null;
	}
}
