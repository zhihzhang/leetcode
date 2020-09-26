package com.lee.aathird;

public class FindDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public char findTheDifference(String s, String t) {
        char x = 0;
        for(char c:s.toCharArray()){
        	x = (char) (x^c);
        }
        for(char c:t.toCharArray()){
        	x = (char) (x^c);
        }
        return x;
    }

}
