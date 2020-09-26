package com.lee.againt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		for(int i=0;i<10;i++){
			obj.insert(i);
		}
		for(int j=0;j<1000;j++){
			System.out.println(obj.getRandom());
		}

	}
	
	List<Integer> list = new ArrayList<>();
	Random random = new Random();
	
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!list.contains((Object)(new Integer(val)))){
        	list.add(val);
        	return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(list.contains((Object)(new Integer(val)))){
        	list.remove((Object)(new Integer(val)));
        	return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	int t = random.nextInt(list.size());
    	return list.get(t);
    }

}
