package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int seed = 100;
	List<Integer>[] data = new List[seed];
	
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        List<Integer> list = data[getHash(key)];
        if(list==null){
        	list = new ArrayList<Integer>();
        	data[getHash(key)] = list;
        }
        if(!list.contains(key)){
        	list.add(key);
        }
    }
    
    public void remove(int key) {
        List<Integer> list = data[getHash(key)];
        if(list==null){
        	list = new ArrayList<Integer>();
        	data[getHash(key)] = list;
        }
        if(list.contains(key)){
        	list.remove((Object)(new Integer(key)));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	List<Integer> list = data[getHash(key)];
    	if(list==null){
        	list = new ArrayList<Integer>();
        	data[getHash(key)] = list;
        }
    	return list.contains(key);
    }
    
    private int getHash(int key){
    	int hash = key%seed;
    	return hash;
    }

}
