package com.lee.again;

public class ReverseStringII {

	public static void main(String[] args) {
		ReverseStringII obj = new ReverseStringII();
		System.out.println(obj.reverseStr("123456789", 2));
	}

	public String reverseStr(String s, int k) {
		char[] array = s.toCharArray();
		int i = 0;
		int j = k - 1;
		while (i < array.length) {
			reverseString(array, i, j);
			i = i + k*2;
			j = j + k*2;
		}
		return new String(array);
	}

	public void reverseString(char[] array, int i, int j) {
		if (j >= array.length) {
			j = array.length - 1;
		}

		while (i < j) {
			char t = array[i];
			array[i] = array[j];
			array[j] = t;
			i++;
			j--;
		}
	}

}
