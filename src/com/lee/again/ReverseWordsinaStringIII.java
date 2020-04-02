package com.lee.again;

public class ReverseWordsinaStringIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseWords(String s) {
		String[] array = s.split(" ");
		for (int i = 0; i < array.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(array[i]);
			array[i] = sb.reverse().toString();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if (i != array.length - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

}
