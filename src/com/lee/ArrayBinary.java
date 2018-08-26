package com.lee;

import java.util.Arrays;

public class ArrayBinary {

	public static void main(String[] args) {
		int[] array = {1,5,7,9,10,30};
		int k = Arrays.binarySearch(array, 9);
		System.out.println(k);
		k = Arrays.binarySearch(array, 6);
		System.out.println(k);

	}

}
