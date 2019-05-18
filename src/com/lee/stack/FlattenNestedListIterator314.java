package com.lee.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator314 implements Iterator<Integer> {
	List<Integer> list = new ArrayList<>();
	int i = -1;
	
	private void parseNi(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.isEmpty()) {
			return;
		}
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				list.add(ni.getInteger());
				continue;
			} else {
				parseNi(ni.getList());
			}
		}
	}

	public FlattenNestedListIterator314(List<NestedInteger> nestedList) {
		parseNi(nestedList);
		if (list.size() > 0) {
			i = 0;
		}
	}

    @Override
    public Integer next() {
		if (i == -1 || i >= list.size()) {
			return null;
		}
        return list.get(i++);
    }

    @Override
    public boolean hasNext() {
        if(i==-1 || i>=list.size()){
        	return false;
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
