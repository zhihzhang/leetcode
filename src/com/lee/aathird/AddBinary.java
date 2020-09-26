package com.lee.aathird;

public class AddBinary {

	public static void main(String[] args) {
		System.out.println(Math.PI);
        double len= Math.sqrt(Math.random())*5;
        System.out.println(len);
        double deg= Math.random()*2*Math.PI;
        System.out.println(deg);

        
        System.out.println(Math.sin(90));
        System.out.println(Math.sin(30));
	}
	
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		String x = new StringBuilder(a).reverse().toString();
		String y = new StringBuilder(b).reverse().toString();
		int i = 0;
		int t = 0;
		while (i < x.length() && i < y.length()) {
			int c0 = x.charAt(i) - '0';
			int c1 = y.charAt(i) - '0';
			int v = c0 + c1 + t;
			if (v == 0) {
				t = 0;
				sb.append('0');
			} else if (v == 1) {
				t = 0;
				sb.append('1');
			} else if (v == 2) {
				t = 1;
				sb.append('0');
			} else {
				t = 1;
				sb.append('1');
			}
			i++;
		}
		while(i < x.length()){
			int c0 = x.charAt(i) - '0';
			int v = c0 + t;
			if (v == 0) {
				t = 0;
				sb.append('0');
			} else if (v == 1) {
				t = 0;
				sb.append('1');
			} else if (v == 2) {
				t = 1;
				sb.append('0');
			}
			i++;
		}
		
		while(i < y.length()){
			int c1 = y.charAt(i) - '0';
			int v = c1 + t;
			if (v == 0) {
				t = 0;
				sb.append('0');
			} else if (v == 1) {
				t = 0;
				sb.append('1');
			} else if (v == 2) {
				t = 1;
				sb.append('0');
			}
			i++;
		}
		if(t==1){
			sb.append(1);
		}
		return sb.reverse().toString();
	}

}
