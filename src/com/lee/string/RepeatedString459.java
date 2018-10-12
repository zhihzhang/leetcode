package com.lee.string;

public class RepeatedString459 {

	public static void main(String[] args) {
		RepeatedString459 obj = new RepeatedString459();
		
		String a = "123123";
		System.out.println(a.substring(0,3));
		System.out.println(a.substring(3,6));

	}
	
//	public boolean repeatedSubstringPattern(String s) {
//		if (s == null || s.length() == 0 || s.length()==1) {
//			return false;
//		}
////		if (s.length() == 1) {
////			return true;
////		}
//		int l = s.length();
//		for (int i = 2; i <= s.length(); i++) {
//			if (l % i == 0) {
//				;
//			}
//		}
//		
//		return false;
//	}
	
	public boolean repeatedSubstringPattern(String str) {
		int l = str.length();
		for(int i=l/2;i>=1;i--) {
			if(l%i==0) {
				int m = l/i;
				String subS = str.substring(0,i);
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<m;j++) {
					sb.append(subS);
				}
				if(sb.toString().equals(str)) return true;
			}
		}
		return false;
	}

}
