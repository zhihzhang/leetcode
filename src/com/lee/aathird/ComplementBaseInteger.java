package com.lee.aathird;

public class ComplementBaseInteger {

	public static void main(String[] args) {
		ComplementBaseInteger obj = new ComplementBaseInteger();
		System.out.println(obj.bitwiseComplement(1));

	}

	public int bitwiseComplement(int N) {
		int i = 1;
		while (i < N) {
			i = i << 1;
		}
		return N ^ i;
	}

}
