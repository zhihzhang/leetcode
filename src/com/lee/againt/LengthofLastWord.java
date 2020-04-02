package com.lee.againt;

public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        if(array.length==0){
        	return 0;
        }
        return array[array.length-1].length();
    }

}
