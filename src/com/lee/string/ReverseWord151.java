package com.lee.string;

public class ReverseWord151 {

	public static void main(String[] args) {
		ReverseWord151 obj = new ReverseWord151();
		System.out.println(obj.reverseWords("the sky is blue"));
	}
	
    public String reverseWords(String s) {
        String[] a = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=a.length-1;i>=0;i--){
        	if(a[i].trim().length()==0){
        		continue;
        	}
        	sb.append(a[i].trim()).append(" ");
        }
        return sb.toString().trim();
    }

}
