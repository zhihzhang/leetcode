package com.lee.again;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman14 {

	public static void main(String[] args) {
		IntegerToRoman14 obj = new IntegerToRoman14();
		int t = 3456;
		System.out.println(obj.intToRoman(t));
//		System.out.println(t/1000);
//		System.out.println(t%1000/100);
//		System.out.println(t%100/10);
//		System.out.println(t%10);
	}
	
    public String intToRoman(int num) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getTho(num/1000));
    	sb.append(getHun(num%1000/100));
    	sb.append(getTen(num%100/10));
    	sb.append(getOne(num%10));
    	
    	return sb.toString();
        
    }
    
    public String getOne(int num){
    	switch (num){
    		case 1: return "I";
    		case 2: return "II";
    		case 3: return "III";
    		case 4: return "IV";
    		case 5: return "V";
    		case 6: return "VI";
    		case 7: return "VII";
    		case 8: return "VIII";
    		case 9: return "IX";
    	}
    	return "";
    }
    
    public String getTen(int num){
    	switch (num){
    		case 1: return "X";
    		case 2: return "XX";
    		case 3: return "XXX";
    		case 4: return "XL";
    		case 5: return "L";
    		case 6: return "LX";
    		case 7: return "LXX";
    		case 8: return "LXXX";
    		case 9: return "XC";
    	}
    	return "";
    }
    
    public String getHun(int num){
    	switch (num){
    		case 1: return "C";
    		case 2: return "CC";
    		case 3: return "CCC";
    		case 4: return "CD";
    		case 5: return "D";
    		case 6: return "DC";
    		case 7: return "DCC";
    		case 8: return "DCCC";
    		case 9: return "CM";
    	}
    	return "";
    }
    
    public String getTho(int num){
    	switch (num){
    		case 1: return "M";
    		case 2: return "MM";
    		case 3: return "MMM";
    	}
    	return "";
    }

}
