package com.lee.again;

public class AddStrings {

	public static void main(String[] args) {
		AddStrings obj = new AddStrings();
		System.out.println(obj.addStrings("1111111", "5678"));

	}

	public String addStrings(String num1, String num2) {

		StringBuilder sb = new StringBuilder();

		int l1 = num1.length() - 1;
		int l2 = num2.length() - 1;

		int t = 0;
		while (l1 >= 0 && l2 >= 0) {
			int a = num1.charAt(l1--) - '0';
			int b = num2.charAt(l2--) - '0';
			int v = a + b + t;
			t = v / 10;
			sb.append(v % 10);
		}
		while(l1>=0){
			int a = num1.charAt(l1--) - '0';
			int v = a + t;
			t = v / 10;
			sb.append(v % 10);
		}
		while(l2>=0){
			int b = num2.charAt(l2--) - '0';
			int v = b + t;
			t = v / 10;
			sb.append(v % 10);
		}
		
		if(t==1){
			sb.append(t);
		}
		sb.reverse();
		return sb.toString();
	}

}
