package com.lee.string;

public class CompareVersion165 {

	public static void main(String[] args) {
		CompareVersion165 obj =  new CompareVersion165();
		int r = obj.compareVersion("1.0", "1");
		System.out.println(r);
	}
	
	public int compareVersion(String version1, String version2) {
		String[] a = version1.split("\\.");
		String[] b = version2.split("\\.");
		int aL = getLength(a);
		int bL = getLength(b);
		int i = 0;
		while (true) {
			int x = Integer.valueOf(a[i]);
			int y = Integer.valueOf(b[i]);
			if (x < y) {
				return -1;
			}
			if (x > y) {
				return 1;
			}

			if (i == aL - 1 && i == bL - 1) {
				return 0;
			} else if (i == aL - 1) {
				return -1;
			} else if (i == bL - 1) {
				return 1;
			}

			i++;
		}

	}
	
	public int getLength(String[] a) {
		if (a.length < 2) {
			return a.length;
		}
		int length = a.length;
		for (int i = a.length - 1; i > 0; i--) {
			int x = Integer.valueOf(a[i]);
			if (x != 0) {
				break;
			} else {
				length--;
			}
		}
		return length;
	}

}
