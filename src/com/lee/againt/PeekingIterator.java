package com.lee.againt;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Iterator<Integer> iterator;
	Integer head = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		if (iterator.hasNext()) {
			head = iterator.next();
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return head;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer t = head;
		if (iterator.hasNext()) {
			head = iterator.next();
		} else {
			head = null;
		}
		return t;
	}

	@Override
	public boolean hasNext() {
		if (head != null) {
			return true;
		}
		return false;
	}

}
