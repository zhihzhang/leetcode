package com.lee.aathird;

public class GuessNumber {

	public static void main(String[] args) {
		GuessNumber obj = new GuessNumber();
		System.out.println(obj.guessNumber(10));

	}
	
	int t = 6;

	public int guessNumber(int n) {
		int l = 1;
		int r = n;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (guess(m) == 0) {
				System.out.println(m + "..A.." + guess(m));
				return m;
			} else if (guess(m) > 0) {
				System.out.println(m + "..B.." + guess(m));
				l = m + 1;
			} else {
				System.out.println(m + "..C.." + guess(m));
				r = m - 1;
			}
		}
		return -1;
	}

	int guess(int num) {
		if(num==6){
			return 0;
		}else if (num<6){
			return -1;
		}else{
			return 1;
		}
	}

}
