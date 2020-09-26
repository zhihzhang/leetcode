package com.lee.aafour;

public class MaximumSwap {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);

	}

	public int maximumSwap(int num) {
		String s = num + "";
		char[] arr = s.toCharArray();
		for (int j = 9; j > 0; j--) {
			for (int i = arr.length - 1; i >= 0; i--) {
				int v = arr[i] - '0';
				if(v==j){
					for(int k=0;k<i;k++){
						if(arr[k]<arr[i]){
							char t = arr[k];
							arr[k] = arr[i];
							arr[i] = t;
							
							String w = new String(arr);
							return Integer.valueOf(w);
						}
					}
				}
			}
		}
		return num;
	}

}
